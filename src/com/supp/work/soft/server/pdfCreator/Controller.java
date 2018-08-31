package com.supp.work.soft.server.pdfCreator;

import java.util.ArrayList;
import java.util.List;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.supp.work.soft.client.GreetingService;
import com.supp.work.soft.client.GreetingServiceAsync;

public class Controller {

	 /**
     * Create a remote service proxy to talk to the server-side pdf
     * service.
     */
    private final GreetingServiceAsync pdfService = GWT
            .create(GreetingService.class);
    private static Controller _instance;

    private Controller() {
    }
    public static synchronized Controller getInstance(){
        if (_instance == null) {
            _instance = new Controller();
        }
        return _instance;
    }
    public GreetingServiceAsync getPdfService() {
        return pdfService;
    }

    
    

    // -------------------- Call Back classes ---------------------------
//    AsyncCallback<String> pdfCallback = new AsyncCallback<String>() {
//        @Override
//        public void onFailure(Throwable caught) {
//            GWT.log("Error in user validation", caught);
//            for (PdfObserver observer : pdfObservers) {
//                observer.notifyPdfGeneratonFail("Login failed: " + caught);
//            }
//        }
//        @Override
//        public void onSuccess(String url) {
//            
//                for (PdfObserver observer : pdfObservers) {
//                    observer.notifyPdfGenratedSuccessfully(url);
//                }
//            
//        }
//    };
}
