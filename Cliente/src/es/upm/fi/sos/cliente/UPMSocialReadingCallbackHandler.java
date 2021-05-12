
/**
 * UPMSocialReadingCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package es.upm.fi.sos.cliente;

    /**
     *  UPMSocialReadingCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class UPMSocialReadingCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public UPMSocialReadingCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public UPMSocialReadingCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for addFriend method
            * override this method for handling normal response from addFriend operation
            */
           public void receiveResultaddFriend(
                    es.upm.fi.sos.cliente.UPMSocialReadingStub.AddFriendResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addFriend operation
           */
            public void receiveErroraddFriend(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeFriend method
            * override this method for handling normal response from removeFriend operation
            */
           public void receiveResultremoveFriend(
                    es.upm.fi.sos.cliente.UPMSocialReadingStub.RemoveFriendResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeFriend operation
           */
            public void receiveErrorremoveFriend(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMyFriendReadings method
            * override this method for handling normal response from getMyFriendReadings operation
            */
           public void receiveResultgetMyFriendReadings(
                    es.upm.fi.sos.cliente.UPMSocialReadingStub.GetMyFriendReadingsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMyFriendReadings operation
           */
            public void receiveErrorgetMyFriendReadings(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMyFriendList method
            * override this method for handling normal response from getMyFriendList operation
            */
           public void receiveResultgetMyFriendList(
                    es.upm.fi.sos.cliente.UPMSocialReadingStub.GetMyFriendListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMyFriendList operation
           */
            public void receiveErrorgetMyFriendList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addUser method
            * override this method for handling normal response from addUser operation
            */
           public void receiveResultaddUser(
                    es.upm.fi.sos.cliente.UPMSocialReadingStub.AddUserResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addUser operation
           */
            public void receiveErroraddUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeUser method
            * override this method for handling normal response from removeUser operation
            */
           public void receiveResultremoveUser(
                    es.upm.fi.sos.cliente.UPMSocialReadingStub.RemoveUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeUser operation
           */
            public void receiveErrorremoveUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMyReadings method
            * override this method for handling normal response from getMyReadings operation
            */
           public void receiveResultgetMyReadings(
                    es.upm.fi.sos.cliente.UPMSocialReadingStub.GetMyReadingsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMyReadings operation
           */
            public void receiveErrorgetMyReadings(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addReading method
            * override this method for handling normal response from addReading operation
            */
           public void receiveResultaddReading(
                    es.upm.fi.sos.cliente.UPMSocialReadingStub.AddReadingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addReading operation
           */
            public void receiveErroraddReading(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changePassword method
            * override this method for handling normal response from changePassword operation
            */
           public void receiveResultchangePassword(
                    es.upm.fi.sos.cliente.UPMSocialReadingStub.ChangePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changePassword operation
           */
            public void receiveErrorchangePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for login method
            * override this method for handling normal response from login operation
            */
           public void receiveResultlogin(
                    es.upm.fi.sos.cliente.UPMSocialReadingStub.LoginResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from login operation
           */
            public void receiveErrorlogin(java.lang.Exception e) {
            }
                


    }
    