package com.github.filipmalczak.inwent.api.security;

public interface Stability {
    String LABEL = "Stability";
    String FROZEN = "[!["+ LABEL+"](https://img.shields.io/badge/"+LABEL+"-FROZEN-blue.svg)](https://shields.io/)";
    String STABLE = "[!["+ LABEL+"](https://img.shields.io/badge/"+LABEL+"-STABLE-green.svg)](https://shields.io/)";
    String EVOLVING = "[!["+ LABEL+"](https://img.shields.io/badge/"+LABEL+"-EVOLVING-yellow.svg)](https://shields.io/)";
}
