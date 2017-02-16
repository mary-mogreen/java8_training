
var String = Java.type('java.lang.String')
var Files = Java.type('java.nio.file.Files')
var Paths = Java.type('java.nio.file.Paths')
var StandardCharsets = Java.type('java.nio.charset.StandardCharsets')

var Arrays = Java.type('java.util.Arrays')
var TreeSet = Java.type('java.util.TreeSet')


var contents = new String(Files.readAllBytes(Paths.get("./alice.txt")), StandardCharsets.UTF_8);

var words = Arrays.asList(contents.split(/\W/))

var set = new TreeSet();

words.stream().filter(function(w) {return w.length > 12} ).forEach(function(w) {set.add(w)})

set.stream().forEach(function(w) { print(w) })
