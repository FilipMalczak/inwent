package com.github.fmd.backend.api;

import com.github.fmd.backend.api.model.LintResponse;
import com.github.fmd.backend.api.model.LintSubjectType;
import com.github.fmd.backend.api.security.annotations.Anonymous;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Tag(name = "Lint for names and paths", description = ValidationAPI.DESCRIPTION)
@Anonymous
@RequestMapping("/api/v${api.version}/lint")
public interface ValidationAPI {
    String DESCRIPTION = """
        <details><summary>Validation rules (click me)</summary>
        <table>
            <tr>
                <th rowspan="2">Subject</th>
                <th colspan="3">Regex</th>
                <th rowspan="2">Canonical joiner</th>
            </tr>
            <tr>
                <th>Canonical</th>
                <th>Allowed</th>
                <th>Allowed joiners</th>
            </tr>
            <tr>
                <td>Name</td>
                <td><code>
                """+Rgx.Name.CANONICAL+"""
                </code></td>
                <td><code>
                """+Rgx.Name.ALLOWED+"""
                </code></td>
                <td><code>
                """+Rgx.Name.SUGAR+"""
                </code></td>
                <td><code>
                """+Rgx.Name.RESOLVED+"""
                </code></td>
            <tr>
            <tr>
                <td>Path</td>
                <td><code>
                """+Rgx.Path.CANONICAL+"""
                </code></td>
                <td><code>
                """+Rgx.Path.ALLOWED+"""
                </code></td>
                <td><code>
                """+Rgx.Path.SUGAR+"""
                </code></td>
                <td><code>
                """+Rgx.Path.RESOLVED+"""
                </code></td>
            <tr>
            <tfoot><tr>
            <td colspan="5"><p>
            To make path or name "canonical", we need to turn it to lowercase, then replace allowed "joiner" characters
            with their canonical versions. Once thats done, we "collapse" multiple joiners next to each other into single one.</p></td> 
            </tr>
            <tr>
            <td colspan="5"><p>
            For example, name <code>a.B .dE</code> will be first turned to <code>a.b .de</code>, then to <code>a.b..de</code> and finally to <code>a.b.de</code>. 
            </p></td> 
            </tr>
            <tr>
            <td colspan="5"><p>
            Canonical path consists of canonical names joined with canonical path joiner. 
            That means that all the changes for names are applied to paths too.
            </p></td>
        </table></details>
        """;
    interface Rgx {

        interface Name {
            String CANONICAL = "[a-z-]+";
            String ALLOWED = "[a-zA-Z-_ ]+";
            String SUGAR = "[_ ]";
            String RESOLVED = "-";
        }

        interface Path {
            String CANONICAL = Name.CANONICAL+"([.]"+ Name.CANONICAL+")*";
            String ALLOWED = Name.ALLOWED+"([.:/]"+ Name.ALLOWED+")*";
            String SUGAR = "[:/]";
            String RESOLVED = ".";
        }
    }

    interface Patterns {
        interface Name {
            Pattern CANONICAL = Pattern.compile(Rgx.Name.CANONICAL);
            Pattern ALLOWED = Pattern.compile(Rgx.Name.ALLOWED);
        }
        interface Path {
            Pattern CANONICAL = Pattern.compile(Rgx.Path.CANONICAL);
            Pattern ALLOWED = Pattern.compile(Rgx.Path.ALLOWED);
        }
    }

    interface Predicates {
        interface Name {
            Predicate<String> CANONICAL = Patterns.Name.CANONICAL.asMatchPredicate();
            Predicate<String> ALLOWED = Patterns.Name.ALLOWED.asMatchPredicate();
        }
        interface Path {
            Predicate<String> CANONICAL = Patterns.Path.CANONICAL.asMatchPredicate();
            Predicate<String> ALLOWED = Patterns.Path.ALLOWED.asMatchPredicate();
        }
    }

    @GetMapping("/name")
    default Mono<LintResponse> nameLint(@RequestParam String subject){
        boolean isCanonical = Predicates.Name.CANONICAL.test(subject);
        boolean isAllowed = Predicates.Name.ALLOWED.test(subject);
        return Mono.just(new LintResponse(
            subject,
            LintSubjectType.NAME,
            isCanonical,
            isAllowed,
            isCanonical ? subject : ( isAllowed ? canonicalizeName(subject) : null )
        ));
    }

    @GetMapping("/path")
    default Mono<LintResponse> pathLint(@RequestParam String subject){
        boolean isCanonical = Predicates.Path.CANONICAL.test(subject);
        boolean isAllowed = Predicates.Path.ALLOWED.test(subject);
        return Mono.just(new LintResponse(
            subject,
            LintSubjectType.PATH,
            isCanonical,
            isAllowed,
            isCanonical ? subject : ( isAllowed ? canonicalizePath(subject) : null )
        ));
    }

    private static String canonicalizeName(String name){
        return name.toLowerCase().replaceAll(Rgx.Name.SUGAR, Rgx.Name.RESOLVED).replaceAll("["+Rgx.Name.RESOLVED+"]+", Rgx.Name.RESOLVED);
    }

    private static String canonicalizePath(String path){
        return canonicalizeName(path).replaceAll(Rgx.Path.SUGAR, Rgx.Path.RESOLVED).replaceAll("["+Rgx.Path.RESOLVED+"]+", Rgx.Path.RESOLVED);
    }

}
