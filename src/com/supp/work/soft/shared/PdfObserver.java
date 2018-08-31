package com.supp.work.soft.shared;

public interface PdfObserver {
	/**
     * Notify the observer pdf generated  successfully
     */
    void notifyPdfGenratedSuccessfully(String url);

    /**
     * Notify the observer pdf generation failed  with error message
     * 
     * @param errorMessage
     * */
    void notifyPdfGeneratonFail(String errorMessage);

}
