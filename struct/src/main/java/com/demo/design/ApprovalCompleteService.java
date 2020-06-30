package com.demo.design;

/**
 * @author chaoshuai.li
 * @date 2020/5/15
 * @description
 */
public class ApprovalCompleteService extends AbstractCompleteService{


    @Override
    protected void clearNotice() {
        super.clearNotice();
    }

    @Override
    protected void doAutoAgree() {

    }

    @Override
    protected void completeWithBranch() {

    }

    @Override
    protected void postAction() {
        instanceEnd();
        super.postAction();
    }


    private void instanceEnd() {

    }
}
