
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

        
            package es.upm.fi.sos;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "Username".equals(typeName)){
                   
                            return  es.upm.fi.sos.xsd.Username.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "FriendList".equals(typeName)){
                   
                            return  es.upm.fi.sos.xsd.FriendList.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "Book".equals(typeName)){
                   
                            return  es.upm.fi.sos.xsd.Book.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "TitleList".equals(typeName)){
                   
                            return  es.upm.fi.sos.xsd.TitleList.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "Response".equals(typeName)){
                   
                            return  es.upm.fi.sos.xsd.Response.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "PasswordPair".equals(typeName)){
                   
                            return  es.upm.fi.sos.xsd.PasswordPair.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "User".equals(typeName)){
                   
                            return  es.upm.fi.sos.xsd.User.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "AddUserResponse".equals(typeName)){
                   
                            return  es.upm.fi.sos.xsd.AddUserResponse.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    