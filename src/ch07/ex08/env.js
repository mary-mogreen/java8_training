/* jjs -scripting env.js */

function allEnv() {
    for (var e in $ENV)
        print(e + '=' + $ENV[e])
}

allEnv()