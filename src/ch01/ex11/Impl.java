package ch01.ex11;

/**
 * Created by mary-mogreen.
 */
public class Impl {

    static class Impl1 implements I1, J1 {@Override public void f() { print("Impl1"); }}

    static class Impl2 implements I1, J2 {@Override public void f() { print("Impl2"); }}

    // static class Impl3 implements I1, J3 {}
    // Error:(12, 19) java: ch01.ex11.Impl.Impl3はabstractでなく、ch01.ex11.I1内のabstractメソッドf()をオーバーライドしません

    static class Impl4 implements I2, J1 {@Override public void f() { print("Impl4"); }}

    static class Impl5 implements I2, J2 {@Override public void f() { print("Impl5"); }}
    // Error:(17, 19) java: クラス ch01.ex11.Impl.Impl5は型ch01.ex11.I2とch01.ex11.J2からf()の関連しないデフォルトを継承します

    static class Impl6 implements I2, J3 {}

    // static class Impl7 implements I3, J1 {}
    // Error:(21, 19) java: ch01.ex11.Impl.Impl7はabstractでなく、ch01.ex11.J1内のabstractメソッドf()をオーバーライドしません

    static class Impl8 implements I3, J2 {}

    static class Impl9 implements I3, J3 {}

    static class Impl10 extends S implements I1 {}
    static class Impl11 extends S implements I2 {}
    static class Impl12 extends S implements I3 {}

    public static void main(String[] args) {
        new Impl1().f();
        new Impl2().f();
        // new Impl3().f();
        new Impl4().f();
        new Impl5().f();
        new Impl6().f(); // Impl6.f();はできない
        //new Impl7().f();
        new Impl8().f(); // Impl8.f();はできない
        // Impl9.f();はできない

        // ========  ======== ======== =========
        //           abstract default  static
        // ========  ======== ======== =========
        // abstract  override override override
        // default   override override default
        // static    override default  override?
        // super     super    super    super
        // ========  ======== ======== =========

        new Impl10().f();
        new Impl11().f();
        new Impl12().f();
    }


    private static void print(String str) {
        System.out.println(str);
    }
}
