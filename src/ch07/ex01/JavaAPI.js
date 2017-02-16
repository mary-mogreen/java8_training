// ch05.ex01 programmersDay
// public static LocalDate programmersDay(int year) {
//         return LocalDate.of(year, 1, 1).plus(Period.ofDays(255));
//     }

function imports(cls) {
    return Java.type(cls)
}

function programmersDay(year) {
    var LocalDate = imports('java.time.LocalDate')
    var Period = imports('java.time.Period')
    return LocalDate.of(year, 1, 1).plus(Period.ofDays(255))
}

print(programmersDay(2016))