/* jjs -scripting nextYear.js -- arg1 */

function nextYear(nowYear) {
    if (nowYear != undefined)
        return new java.lang.Integer(nowYear) + 1
    nowYear = $ENV['AGE'] === undefined ? readLine("Your Age: ") : $ENV['AGE']
    return new java.lang.Integer(nowYear) + 1
}

print('Next year, you will be ... ' + nextYear(arguments[0]))