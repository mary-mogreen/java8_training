function pipe() {
    if (arguments.length == 0)
        return 'ex) pipe(\'find .\', \'grep -v class\', \'sort\')'
    
    var ret = $EXEC(arguments[0])
    for (var i = 1; i < arguments.length; i++) {
        ret = $EXEC(arguments[i], ret)
    }
    return ret
}

print(pipe())
print(pipe('find .', 'grep -v class', 'sort'))
