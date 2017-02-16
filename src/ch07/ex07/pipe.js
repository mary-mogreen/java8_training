function pipe() {
    if (arguments.length == 0)
        return 'ex) pipe(\'find .\', \'grep -v class\', \'sort\')'
    
    var ret = getProcessInputStream(arguments[0])
    for (var i = 1; i < arguments.length; i++) {
        ret = getProcessInputStream(arguments[i], ret)
    }
    
    return toString(ret)
}

print(pipe())
print(pipe('find .', 'grep -v class', 'sort'))

function imports(cls) {
    return Java.type(cls)
}

// 文字列に変換
function toString(inputStream) {
    var BR = imports('java.io.BufferedReader')
    var ISR = imports('java.io.InputStreamReader')
    var SB = imports('java.lang.StringBuilder')
    var S = imports('java.lang.String')

    var br = new BR(new ISR(inputStream))

    var sb = new SB()

    var line
    while ((line = br.readLine()))
        sb.append(line).append('\n')
    br.close()
    return sb.toString()
}

// ProcessBuilder でコマンドを処理
function getProcessInputStream(command, inputStream) {
    var ProcessBuilder = imports('java.lang.ProcessBuilder')
    var Thread = imports('java.lang.Thread')
    var cmd = command.split(' ')
    var processBuilder
    var process

    processBuilder = new ProcessBuilder(cmd)
    process = processBuilder.start()
    // 前の処理があれば，その内容を入力として渡す
    if (inputStream != undefined) {
        new Thread(function() {
            var b
            var out = process.getOutputStream()
            while ((b = inputStream.read()) != -1) {
                out.write(b)
            }
            out.close()
        }).start()
    }
    return process.getInputStream() 
}

