package jp.earley.javakit;

import java.util.function.BooleanSupplier;

public class Bool {
    private boolean flag;

    public Bool(boolean flag) {
        this.flag = flag;
    }

    public static Bool of(boolean flag) {
        return new Bool(flag);
    }

    public Bool setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    public boolean getFlag() {
        return this.flag;
    }

    public boolean isTrue() {
        return getFlag();
    }

    public boolean isFalse() {
        return !getFlag();
    }

    /**
     * Trueの場合です。
     *
     * @param runner ランナ
     * @return 結果
     */
    public Bool ifTrue(Runnable runner) {
        if (isTrue()) {
            runner.run();
        }
        return this;
    }

    /**
     * Trueの場合です。
     *
     * @param supplier サプライヤ
     * @return 結果
     */
    public Bool ifTrueMore(BooleanSupplier supplier) {
        if (isTrue()) {
            this.flag = supplier.getAsBoolean();
        }
        return this;
    }

    /**
     * Falseの場合です。
     *
     * @param runner ランナ
     * @return 結果
     */
    public Bool ifFalse(Runnable runner) {
        if (isFalse()) {
            runner.run();
        }
        return this;
    }
}
