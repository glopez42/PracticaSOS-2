
/**
 * UPMSocialReadingMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package es.upm.fi.sos;

        /**
        *  UPMSocialReadingMessageReceiverInOut message receiver
        */

        public class UPMSocialReadingMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        UPMSocialReadingSkeleton skel = (UPMSocialReadingSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("addFriend".equals(methodName)){
                
                es.upm.fi.sos.AddFriendResponse addFriendResponse44 = null;
	                        es.upm.fi.sos.AddFriend wrappedParam =
                                                             (es.upm.fi.sos.AddFriend)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.AddFriend.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addFriendResponse44 =
                                                   
                                                   
                                                         skel.addFriend(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addFriendResponse44, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "addFriend"));
                                    } else 

            if("removeFriend".equals(methodName)){
                
                es.upm.fi.sos.RemoveFriendResponse removeFriendResponse46 = null;
	                        es.upm.fi.sos.RemoveFriend wrappedParam =
                                                             (es.upm.fi.sos.RemoveFriend)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.RemoveFriend.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               removeFriendResponse46 =
                                                   
                                                   
                                                         skel.removeFriend(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), removeFriendResponse46, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "removeFriend"));
                                    } else 

            if("getMyFriendReadings".equals(methodName)){
                
                es.upm.fi.sos.GetMyFriendReadingsResponse getMyFriendReadingsResponse48 = null;
	                        es.upm.fi.sos.GetMyFriendReadings wrappedParam =
                                                             (es.upm.fi.sos.GetMyFriendReadings)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.GetMyFriendReadings.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getMyFriendReadingsResponse48 =
                                                   
                                                   
                                                         skel.getMyFriendReadings(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getMyFriendReadingsResponse48, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "getMyFriendReadings"));
                                    } else 

            if("getMyFriendList".equals(methodName)){
                
                es.upm.fi.sos.GetMyFriendListResponse getMyFriendListResponse50 = null;
	                        es.upm.fi.sos.GetMyFriendList wrappedParam =
                                                             (es.upm.fi.sos.GetMyFriendList)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.GetMyFriendList.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getMyFriendListResponse50 =
                                                   
                                                   
                                                         skel.getMyFriendList(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getMyFriendListResponse50, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "getMyFriendList"));
                                    } else 

            if("addUser".equals(methodName)){
                
                es.upm.fi.sos.AddUserResponse addUserResponse52 = null;
	                        es.upm.fi.sos.AddUser wrappedParam =
                                                             (es.upm.fi.sos.AddUser)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.AddUser.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addUserResponse52 =
                                                   
                                                   
                                                         skel.addUser(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addUserResponse52, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "addUser"));
                                    } else 

            if("removeUser".equals(methodName)){
                
                es.upm.fi.sos.RemoveUserResponse removeUserResponse54 = null;
	                        es.upm.fi.sos.RemoveUser wrappedParam =
                                                             (es.upm.fi.sos.RemoveUser)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.RemoveUser.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               removeUserResponse54 =
                                                   
                                                   
                                                         skel.removeUser(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), removeUserResponse54, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "removeUser"));
                                    } else 

            if("getMyReadings".equals(methodName)){
                
                es.upm.fi.sos.GetMyReadingsResponse getMyReadingsResponse56 = null;
	                        es.upm.fi.sos.GetMyReadings wrappedParam =
                                                             (es.upm.fi.sos.GetMyReadings)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.GetMyReadings.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getMyReadingsResponse56 =
                                                   
                                                   
                                                         skel.getMyReadings(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getMyReadingsResponse56, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "getMyReadings"));
                                    } else 

            if("addReading".equals(methodName)){
                
                es.upm.fi.sos.AddReadingResponse addReadingResponse58 = null;
	                        es.upm.fi.sos.AddReading wrappedParam =
                                                             (es.upm.fi.sos.AddReading)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.AddReading.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addReadingResponse58 =
                                                   
                                                   
                                                         skel.addReading(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addReadingResponse58, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "addReading"));
                                    } else 

            if("changePassword".equals(methodName)){
                
                es.upm.fi.sos.ChangePasswordResponse changePasswordResponse60 = null;
	                        es.upm.fi.sos.ChangePassword wrappedParam =
                                                             (es.upm.fi.sos.ChangePassword)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.ChangePassword.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               changePasswordResponse60 =
                                                   
                                                   
                                                         skel.changePassword(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), changePasswordResponse60, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "changePassword"));
                                    } else 

            if("login".equals(methodName)){
                
                es.upm.fi.sos.LoginResponse loginResponse62 = null;
	                        es.upm.fi.sos.Login wrappedParam =
                                                             (es.upm.fi.sos.Login)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.Login.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               loginResponse62 =
                                                   
                                                   
                                                         skel.login(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), loginResponse62, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "login"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.Logout param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.Logout.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.AddFriend param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.AddFriend.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.AddFriendResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.AddFriendResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.RemoveFriend param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.RemoveFriend.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.RemoveFriendResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.RemoveFriendResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyFriendReadings param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyFriendReadings.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyFriendReadingsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyFriendReadingsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyFriendList param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyFriendList.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyFriendListResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyFriendListResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.AddUser param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.AddUser.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.AddUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.AddUserResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.RemoveUser param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.RemoveUser.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.RemoveUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.RemoveUserResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyReadings param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyReadings.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyReadingsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyReadingsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.AddReading param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.AddReading.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.AddReadingResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.AddReadingResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.ChangePassword param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.ChangePassword.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.ChangePasswordResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.ChangePasswordResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.Login param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.Login.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.LoginResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.LoginResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.AddFriendResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.AddFriendResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.AddFriendResponse wrapaddFriend(){
                                es.upm.fi.sos.AddFriendResponse wrappedElement = new es.upm.fi.sos.AddFriendResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.RemoveFriendResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.RemoveFriendResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.RemoveFriendResponse wrapremoveFriend(){
                                es.upm.fi.sos.RemoveFriendResponse wrappedElement = new es.upm.fi.sos.RemoveFriendResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.GetMyFriendReadingsResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.GetMyFriendReadingsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.GetMyFriendReadingsResponse wrapgetMyFriendReadings(){
                                es.upm.fi.sos.GetMyFriendReadingsResponse wrappedElement = new es.upm.fi.sos.GetMyFriendReadingsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.GetMyFriendListResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.GetMyFriendListResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.GetMyFriendListResponse wrapgetMyFriendList(){
                                es.upm.fi.sos.GetMyFriendListResponse wrappedElement = new es.upm.fi.sos.GetMyFriendListResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.AddUserResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.AddUserResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.AddUserResponse wrapaddUser(){
                                es.upm.fi.sos.AddUserResponse wrappedElement = new es.upm.fi.sos.AddUserResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.RemoveUserResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.RemoveUserResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.RemoveUserResponse wrapremoveUser(){
                                es.upm.fi.sos.RemoveUserResponse wrappedElement = new es.upm.fi.sos.RemoveUserResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.GetMyReadingsResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.GetMyReadingsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.GetMyReadingsResponse wrapgetMyReadings(){
                                es.upm.fi.sos.GetMyReadingsResponse wrappedElement = new es.upm.fi.sos.GetMyReadingsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.AddReadingResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.AddReadingResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.AddReadingResponse wrapaddReading(){
                                es.upm.fi.sos.AddReadingResponse wrappedElement = new es.upm.fi.sos.AddReadingResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.ChangePasswordResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.ChangePasswordResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.ChangePasswordResponse wrapchangePassword(){
                                es.upm.fi.sos.ChangePasswordResponse wrappedElement = new es.upm.fi.sos.ChangePasswordResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.LoginResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.LoginResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.LoginResponse wraplogin(){
                                es.upm.fi.sos.LoginResponse wrappedElement = new es.upm.fi.sos.LoginResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (es.upm.fi.sos.Logout.class.equals(type)){
                
                           return es.upm.fi.sos.Logout.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.AddFriend.class.equals(type)){
                
                           return es.upm.fi.sos.AddFriend.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.AddFriendResponse.class.equals(type)){
                
                           return es.upm.fi.sos.AddFriendResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.RemoveFriend.class.equals(type)){
                
                           return es.upm.fi.sos.RemoveFriend.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.RemoveFriendResponse.class.equals(type)){
                
                           return es.upm.fi.sos.RemoveFriendResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyFriendReadings.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyFriendReadings.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyFriendReadingsResponse.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyFriendReadingsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyFriendList.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyFriendList.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyFriendListResponse.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyFriendListResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.AddUser.class.equals(type)){
                
                           return es.upm.fi.sos.AddUser.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.AddUserResponse.class.equals(type)){
                
                           return es.upm.fi.sos.AddUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.RemoveUser.class.equals(type)){
                
                           return es.upm.fi.sos.RemoveUser.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.RemoveUserResponse.class.equals(type)){
                
                           return es.upm.fi.sos.RemoveUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyReadings.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyReadings.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyReadingsResponse.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyReadingsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.AddReading.class.equals(type)){
                
                           return es.upm.fi.sos.AddReading.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.AddReadingResponse.class.equals(type)){
                
                           return es.upm.fi.sos.AddReadingResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.ChangePassword.class.equals(type)){
                
                           return es.upm.fi.sos.ChangePassword.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.ChangePasswordResponse.class.equals(type)){
                
                           return es.upm.fi.sos.ChangePasswordResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.Login.class.equals(type)){
                
                           return es.upm.fi.sos.Login.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.LoginResponse.class.equals(type)){
                
                           return es.upm.fi.sos.LoginResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    