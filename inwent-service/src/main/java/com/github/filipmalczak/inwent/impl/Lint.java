package com.github.filipmalczak.inwent.impl;

import com.github.filipmalczak.inwent.api.ValidationAPI;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lint implements ValidationAPI {
    //yep, validation API contains the whole implementation; that is by design - the business rules about tag and path formats are part of the API
}
