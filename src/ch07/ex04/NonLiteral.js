/*jjs>*/ var str = 'test, test'.split(/\W/)[0]
/*jjs>*/ print(str.getClass())
// class java.lang.String
/*jjs>*/ java.lang.String.class.cast(str)
// test