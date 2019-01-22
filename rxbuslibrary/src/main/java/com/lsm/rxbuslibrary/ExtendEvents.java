package com.lsm.rxbuslibrary;

/**
 * <p>
 *  事件的累计
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2018/12/4 20:23
 */

public class ExtendEvents<T> {

    private int code;

    private T content;

    private int mflagChoose;

    public ExtendEvents(int code, T content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public int getFlagChoose() {
        return mflagChoose;
    }

    /**
     * 如果你要标记其他的选项
     * @param mflagChoose
     */
    public void setFlagChoose(int mflagChoose) {
        this.mflagChoose = mflagChoose;
    }

    @Override
    public String toString() {
        return "ExtendEvents 接受的="+code;
    }
}
