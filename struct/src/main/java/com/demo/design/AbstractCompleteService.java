package com.demo.design;

/**
 * @author chaoshuai.li
 * @date 2020/5/15
 * @description
 */
public abstract class AbstractCompleteService {

    public void complete() {
        /**
         * 1. 前置处理 （校验 任务 实例 rule）
         * 2. 执行action（协同 取消提醒 和CRM审批处理合并）
         * 3. action的后置处理 （自动通过/回退）
         */
        preAction();
        doAction();
        postAction();
    }

    protected void postAction() {
        doAutoAgree();
        doAutoAgreeErrorTask();
    }


    private void doAutoAgreeErrorTask() {

    }

    /**
     * auto agree
     */
    protected abstract void doAutoAgree();


    protected void doAction() {
        // maybe there is something to override
        // do something then
        completeWithBranch();
        clearNotice();
    }

    protected void clearNotice() {
    }

    protected void preAction() {

    }


    protected abstract void completeWithBranch();
}
