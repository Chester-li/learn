package com.demo.design;

/**
 * @author chaoshuai.li
 * @date 2020/5/15
 * @description
 */
public class XTCompleteService extends AbstractCompleteService{

    @Override
    protected void preAction(){
        super.preAction();
    }

    @Override
    protected void clearNotice() {
        super.clearNotice();
    }

    @Override
    protected void doAutoAgree() {

    }

    @Override
    protected void completeWithBranch(){

    }

    @Override
    protected void postAction() {
        super.postAction();
        doAutoGoBack();
        doAutoGoBackErrorTask();
    }

    private void doAutoGoBackErrorTask() {

    }

    private void doAutoGoBack() {

    }
}
