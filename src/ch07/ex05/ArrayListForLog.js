
function newArrayListForLog() {
    var arr = new (Java.extend(java.util.ArrayList)) {
        add: function(x) {
            print ('Adding ' + x)
            return Java.super(arr).add(x)
        }
    }
    return arr
}

var array = newArrayListForLog()

array.add('test')
array.add('test2')

var array2 = newArrayListForLog()

array2.add('TEST')
array2.add('TEST2')