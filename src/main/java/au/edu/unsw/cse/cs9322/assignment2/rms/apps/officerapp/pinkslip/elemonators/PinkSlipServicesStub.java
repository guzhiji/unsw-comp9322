/**
 * PinkSlipServicesStub.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators;

/*
 *  PinkSlipServicesStub java implementation
 */
public class PinkSlipServicesStub extends org.apache.axis2.client.Stub {

    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();

    private static int counter = 0;

    private static synchronized java.lang.String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }
        counter = counter + 1;
        return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault {

        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService("PinkSlipServices" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[2];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://phanh.se/services", "vehicleInfo"));
        _service.addOperation(__operation);

        _operations[0] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://phanh.se/services", "pSCheck"));
        _service.addOperation(__operation);

        _operations[1] = __operation;

    }

    //populates the faults
    private void populateFaults() {

        faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://phanh.se/services", "pinkSlipFault"), "vehicleInfo"), "au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException");
        faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://phanh.se/services", "pinkSlipFault"), "vehicleInfo"), "au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException");
        faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://phanh.se/services", "pinkSlipFault"), "vehicleInfo"), "au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub$PinkSlipFault");

        faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://phanh.se/services", "pinkSlipFault"), "pSCheck"), "au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException");
        faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://phanh.se/services", "pinkSlipFault"), "pSCheck"), "au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException");
        faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://phanh.se/services", "pinkSlipFault"), "pSCheck"), "au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub$PinkSlipFault");

    }

    /**
     * Constructor that takes in a configContext
     */
    public PinkSlipServicesStub(org.apache.axis2.context.ConfigurationContext configurationContext,
            java.lang.String targetEndpoint)
            throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext and useseperate listner
     */
    public PinkSlipServicesStub(org.apache.axis2.context.ConfigurationContext configurationContext,
            java.lang.String targetEndpoint, boolean useSeparateListener)
            throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

    }

    /**
     * Default Constructor
     */
    public PinkSlipServicesStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {

        this(configurationContext, "http://localhost:8080/axis2/services/e-lemon-ators/PinkSlipServices/");

    }

    /**
     * Default Constructor
     */
    public PinkSlipServicesStub() throws org.apache.axis2.AxisFault {

        this("http://localhost:8080/axis2/services/e-lemon-ators/PinkSlipServices/");

    }

    /**
     * Constructor taking the target endpoint
     */
    public PinkSlipServicesStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    /**
     * Auto generated method signature
     *
     * @see
     * au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServices#vehicleInfo
     * @param driver
     *
     * @throws
     * au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException
     * :
     */
    public au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.VehicleInfoResponse vehicleInfo(
            au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.Driver driver)
            throws java.rmi.RemoteException, au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions().setAction("urn:vehicleInfo");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    driver,
                    optimizeContent(new javax.xml.namespace.QName("http://phanh.se/services",
                                    "vehicleInfo")), new javax.xml.namespace.QName("http://phanh.se/services",
                            "vehicleInfo"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.VehicleInfoResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.VehicleInfoResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "vehicleInfo"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "vehicleInfo"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "vehicleInfo"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});

                        if (ex instanceof au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException) {
                            throw (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature
     *
     * @see
     * au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServices#pSCheck
     * @param driver0
     *
     * @throws
     * au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException
     * :
     */
    public au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PSCheckResponse pSCheck(
            au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.Driver driver0)
            throws java.rmi.RemoteException, au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
            _operationClient.getOptions().setAction("urn:pSCheck");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    driver0,
                    optimizeContent(new javax.xml.namespace.QName("http://phanh.se/services",
                                    "pSCheck")), new javax.xml.namespace.QName("http://phanh.se/services",
                            "pSCheck"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PSCheckResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PSCheckResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "pSCheck"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "pSCheck"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "pSCheck"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});

                        if (ex instanceof au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException) {
                            throw (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipFaultException) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }

    private javax.xml.namespace.QName[] opNameArray = null;

    private boolean optimizeContent(javax.xml.namespace.QName opName) {

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }
        return false;
    }

    //http://localhost:8080/axis2/services/e-lemon-ators/PinkSlipServices/

    public static class Driver
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://phanh.se/services",
                "driver",
                "ns1");

        /**
         * field for FirstName
         */
        protected java.lang.String localFirstName;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getFirstName() {
            return localFirstName;
        }

        /**
         * Auto generated setter method
         *
         * @param param FirstName
         */
        public void setFirstName(java.lang.String param) {

            this.localFirstName = param;

        }

        /**
         * field for LastName
         */
        protected java.lang.String localLastName;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getLastName() {
            return localLastName;
        }

        /**
         * Auto generated setter method
         *
         * @param param LastName
         */
        public void setLastName(java.lang.String param) {

            this.localLastName = param;

        }

        /**
         * field for RegoNumber
         */
        protected java.lang.String localRegoNumber;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getRegoNumber() {
            return localRegoNumber;
        }

        /**
         * Auto generated setter method
         *
         * @param param RegoNumber
         */
        public void setRegoNumber(java.lang.String param) {

            this.localRegoNumber = param;

        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://phanh.se/services");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":driver",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "driver",
                            xmlWriter);
                }

            }

            namespace = "http://phanh.se/services";
            writeStartElement(null, namespace, "firstName", xmlWriter);

            if (localFirstName == null) {
                                              // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("firstName cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localFirstName);

            }

            xmlWriter.writeEndElement();

            namespace = "http://phanh.se/services";
            writeStartElement(null, namespace, "lastName", xmlWriter);

            if (localLastName == null) {
                                              // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("lastName cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localLastName);

            }

            xmlWriter.writeEndElement();

            namespace = "http://phanh.se/services";
            writeStartElement(null, namespace, "regoNumber", xmlWriter);

            if (localRegoNumber == null) {
                                              // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("regoNumber cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localRegoNumber);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://phanh.se/services")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "firstName"));

            if (localFirstName != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFirstName));
            } else {
                throw new org.apache.axis2.databinding.ADBException("firstName cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "lastName"));

            if (localLastName != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastName));
            } else {
                throw new org.apache.axis2.databinding.ADBException("lastName cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "regoNumber"));

            if (localRegoNumber != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRegoNumber));
            } else {
                throw new org.apache.axis2.databinding.ADBException("regoNumber cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static Driver parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Driver object
                        = new Driver();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"driver".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Driver) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }

                        }

                    }

                // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "firstName").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "firstName" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setFirstName(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "lastName").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "lastName" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setLastName(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "regoNumber").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "regoNumber" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setRegoNumber(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class PinkSlipFault
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://phanh.se/services",
                "pinkSlipFault",
                "ns1");

        /**
         * field for FaultType
         */
        protected PinkSlipFaultType localFaultType;

        /**
         * Auto generated getter method
         *
         * @return PinkSlipFaultType
         */
        public PinkSlipFaultType getFaultType() {
            return localFaultType;
        }

        /**
         * Auto generated setter method
         *
         * @param param FaultType
         */
        public void setFaultType(PinkSlipFaultType param) {

            this.localFaultType = param;

        }

        /**
         * field for FaultMessage
         */
        protected java.lang.String localFaultMessage;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getFaultMessage() {
            return localFaultMessage;
        }

        /**
         * Auto generated setter method
         *
         * @param param FaultMessage
         */
        public void setFaultMessage(java.lang.String param) {

            this.localFaultMessage = param;

        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://phanh.se/services");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":pinkSlipFault",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "pinkSlipFault",
                            xmlWriter);
                }

            }

            if (localFaultType == null) {
                throw new org.apache.axis2.databinding.ADBException("faultType cannot be null!!");
            }
            localFaultType.serialize(new javax.xml.namespace.QName("http://phanh.se/services", "faultType"),
                    xmlWriter);

            namespace = "http://phanh.se/services";
            writeStartElement(null, namespace, "faultMessage", xmlWriter);

            if (localFaultMessage == null) {
                                              // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("faultMessage cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localFaultMessage);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://phanh.se/services")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "faultType"));

            if (localFaultType == null) {
                throw new org.apache.axis2.databinding.ADBException("faultType cannot be null!!");
            }
            elementList.add(localFaultType);

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "faultMessage"));

            if (localFaultMessage != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFaultMessage));
            } else {
                throw new org.apache.axis2.databinding.ADBException("faultMessage cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static PinkSlipFault parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                PinkSlipFault object
                        = new PinkSlipFault();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"pinkSlipFault".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (PinkSlipFault) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }

                        }

                    }

                // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "faultType").equals(reader.getName())) {

                        object.setFaultType(PinkSlipFaultType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "faultMessage").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "faultMessage" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setFaultMessage(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class ExtensionMapper {

        public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                java.lang.String typeName,
                javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {

            if ("http://phanh.se/services".equals(namespaceURI)
                    && "pinkSlipFaultType".equals(typeName)) {

                return PinkSlipFaultType.Factory.parse(reader);

            }

            if ("http://phanh.se/services".equals(namespaceURI)
                    && "vehicleType".equals(typeName)) {

                return VehicleType.Factory.parse(reader);

            }

            if ("http://phanh.se/services".equals(namespaceURI)
                    && "checkedFlag".equals(typeName)) {

                return CheckedFlag.Factory.parse(reader);

            }

            throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }

    }

    public static class PSCheckResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://phanh.se/services",
                "pSCheckResponse",
                "ns1");

        /**
         * field for FirstName
         */
        protected java.lang.String localFirstName;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getFirstName() {
            return localFirstName;
        }

        /**
         * Auto generated setter method
         *
         * @param param FirstName
         */
        public void setFirstName(java.lang.String param) {

            this.localFirstName = param;

        }

        /**
         * field for LastName
         */
        protected java.lang.String localLastName;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getLastName() {
            return localLastName;
        }

        /**
         * Auto generated setter method
         *
         * @param param LastName
         */
        public void setLastName(java.lang.String param) {

            this.localLastName = param;

        }

        /**
         * field for RegoNumber
         */
        protected java.lang.String localRegoNumber;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getRegoNumber() {
            return localRegoNumber;
        }

        /**
         * Auto generated setter method
         *
         * @param param RegoNumber
         */
        public void setRegoNumber(java.lang.String param) {

            this.localRegoNumber = param;

        }

        /**
         * field for CheckedFlag
         */
        protected CheckedFlag localCheckedFlag;

        /**
         * Auto generated getter method
         *
         * @return CheckedFlag
         */
        public CheckedFlag getCheckedFlag() {
            return localCheckedFlag;
        }

        /**
         * Auto generated setter method
         *
         * @param param CheckedFlag
         */
        public void setCheckedFlag(CheckedFlag param) {

            this.localCheckedFlag = param;

        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://phanh.se/services");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":pSCheckResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "pSCheckResponse",
                            xmlWriter);
                }

            }

            namespace = "http://phanh.se/services";
            writeStartElement(null, namespace, "firstName", xmlWriter);

            if (localFirstName == null) {
                                              // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("firstName cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localFirstName);

            }

            xmlWriter.writeEndElement();

            namespace = "http://phanh.se/services";
            writeStartElement(null, namespace, "lastName", xmlWriter);

            if (localLastName == null) {
                                              // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("lastName cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localLastName);

            }

            xmlWriter.writeEndElement();

            namespace = "http://phanh.se/services";
            writeStartElement(null, namespace, "regoNumber", xmlWriter);

            if (localRegoNumber == null) {
                                              // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("regoNumber cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localRegoNumber);

            }

            xmlWriter.writeEndElement();

            if (localCheckedFlag == null) {
                throw new org.apache.axis2.databinding.ADBException("checkedFlag cannot be null!!");
            }
            localCheckedFlag.serialize(new javax.xml.namespace.QName("http://phanh.se/services", "checkedFlag"),
                    xmlWriter);

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://phanh.se/services")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "firstName"));

            if (localFirstName != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFirstName));
            } else {
                throw new org.apache.axis2.databinding.ADBException("firstName cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "lastName"));

            if (localLastName != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastName));
            } else {
                throw new org.apache.axis2.databinding.ADBException("lastName cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "regoNumber"));

            if (localRegoNumber != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRegoNumber));
            } else {
                throw new org.apache.axis2.databinding.ADBException("regoNumber cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "checkedFlag"));

            if (localCheckedFlag == null) {
                throw new org.apache.axis2.databinding.ADBException("checkedFlag cannot be null!!");
            }
            elementList.add(localCheckedFlag);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static PSCheckResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                PSCheckResponse object
                        = new PSCheckResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"pSCheckResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (PSCheckResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }

                        }

                    }

                // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "firstName").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "firstName" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setFirstName(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "lastName").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "lastName" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setLastName(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "regoNumber").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "regoNumber" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setRegoNumber(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "checkedFlag").equals(reader.getName())) {

                        object.setCheckedFlag(CheckedFlag.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class VehicleInfoResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://phanh.se/services",
                "vehicleInfoResponse",
                "ns1");

        /**
         * field for FirstName
         */
        protected java.lang.String localFirstName;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getFirstName() {
            return localFirstName;
        }

        /**
         * Auto generated setter method
         *
         * @param param FirstName
         */
        public void setFirstName(java.lang.String param) {

            this.localFirstName = param;

        }

        /**
         * field for LastName
         */
        protected java.lang.String localLastName;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getLastName() {
            return localLastName;
        }

        /**
         * Auto generated setter method
         *
         * @param param LastName
         */
        public void setLastName(java.lang.String param) {

            this.localLastName = param;

        }

        /**
         * field for RegoNumber
         */
        protected java.lang.String localRegoNumber;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getRegoNumber() {
            return localRegoNumber;
        }

        /**
         * Auto generated setter method
         *
         * @param param RegoNumber
         */
        public void setRegoNumber(java.lang.String param) {

            this.localRegoNumber = param;

        }

        /**
         * field for ManufacturedDate
         */
        protected java.util.Calendar localManufacturedDate;

        /**
         * Auto generated getter method
         *
         * @return java.util.Calendar
         */
        public java.util.Calendar getManufacturedDate() {
            return localManufacturedDate;
        }

        /**
         * Auto generated setter method
         *
         * @param param ManufacturedDate
         */
        public void setManufacturedDate(java.util.Calendar param) {

            this.localManufacturedDate = param;

        }

        /**
         * field for VehicleType
         */
        protected VehicleType localVehicleType;

        /**
         * Auto generated getter method
         *
         * @return VehicleType
         */
        public VehicleType getVehicleType() {
            return localVehicleType;
        }

        /**
         * Auto generated setter method
         *
         * @param param VehicleType
         */
        public void setVehicleType(VehicleType param) {

            this.localVehicleType = param;

        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://phanh.se/services");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":vehicleInfoResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "vehicleInfoResponse",
                            xmlWriter);
                }

            }

            namespace = "http://phanh.se/services";
            writeStartElement(null, namespace, "firstName", xmlWriter);

            if (localFirstName == null) {
                                              // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("firstName cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localFirstName);

            }

            xmlWriter.writeEndElement();

            namespace = "http://phanh.se/services";
            writeStartElement(null, namespace, "lastName", xmlWriter);

            if (localLastName == null) {
                                              // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("lastName cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localLastName);

            }

            xmlWriter.writeEndElement();

            namespace = "http://phanh.se/services";
            writeStartElement(null, namespace, "regoNumber", xmlWriter);

            if (localRegoNumber == null) {
                                              // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("regoNumber cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localRegoNumber);

            }

            xmlWriter.writeEndElement();

            namespace = "http://phanh.se/services";
            writeStartElement(null, namespace, "manufacturedDate", xmlWriter);

            if (localManufacturedDate == null) {
                                              // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("manufacturedDate cannot be null!!");

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localManufacturedDate));

            }

            xmlWriter.writeEndElement();

            if (localVehicleType == null) {
                throw new org.apache.axis2.databinding.ADBException("vehicleType cannot be null!!");
            }
            localVehicleType.serialize(new javax.xml.namespace.QName("http://phanh.se/services", "vehicleType"),
                    xmlWriter);

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://phanh.se/services")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "firstName"));

            if (localFirstName != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFirstName));
            } else {
                throw new org.apache.axis2.databinding.ADBException("firstName cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "lastName"));

            if (localLastName != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastName));
            } else {
                throw new org.apache.axis2.databinding.ADBException("lastName cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "regoNumber"));

            if (localRegoNumber != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRegoNumber));
            } else {
                throw new org.apache.axis2.databinding.ADBException("regoNumber cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "manufacturedDate"));

            if (localManufacturedDate != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localManufacturedDate));
            } else {
                throw new org.apache.axis2.databinding.ADBException("manufacturedDate cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://phanh.se/services",
                    "vehicleType"));

            if (localVehicleType == null) {
                throw new org.apache.axis2.databinding.ADBException("vehicleType cannot be null!!");
            }
            elementList.add(localVehicleType);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static VehicleInfoResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                VehicleInfoResponse object
                        = new VehicleInfoResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"vehicleInfoResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (VehicleInfoResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }

                        }

                    }

                // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "firstName").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "firstName" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setFirstName(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "lastName").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "lastName" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setLastName(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "regoNumber").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "regoNumber" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setRegoNumber(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "manufacturedDate").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "manufacturedDate" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setManufacturedDate(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://phanh.se/services", "vehicleType").equals(reader.getName())) {

                        object.setVehicleType(VehicleType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class VehicleType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://phanh.se/services",
                "vehicleType",
                "ns1");

        /**
         * field for VehicleType
         */
        protected java.lang.String localVehicleType;

        private static java.util.HashMap _table_ = new java.util.HashMap();

                            // Constructor
        protected VehicleType(java.lang.String value, boolean isRegisterValue) {
            localVehicleType = value;
            if (isRegisterValue) {

                _table_.put(localVehicleType, this);

            }

        }

        public static final java.lang.String _Heavy
                = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Heavy");

        public static final java.lang.String _Light
                = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Light");

        public static final VehicleType Heavy
                = new VehicleType(_Heavy, true);

        public static final VehicleType Light
                = new VehicleType(_Light, true);

        public java.lang.String getValue() {
            return localVehicleType;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj == this);
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public java.lang.String toString() {

            return localVehicleType.toString();

        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

                //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://phanh.se/services");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":vehicleType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "vehicleType",
                            xmlWriter);
                }
            }

            if (localVehicleType == null) {

                throw new org.apache.axis2.databinding.ADBException("vehicleType cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localVehicleType);

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://phanh.se/services")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVehicleType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static VehicleType fromValue(java.lang.String value)
                    throws java.lang.IllegalArgumentException {
                VehicleType enumeration = (VehicleType) _table_.get(value);

                if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                    throw new java.lang.IllegalArgumentException();
                }
                return enumeration;
            }

            public static VehicleType fromString(java.lang.String value, java.lang.String namespaceURI)
                    throws java.lang.IllegalArgumentException {
                try {

                    return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                } catch (java.lang.Exception e) {
                    throw new java.lang.IllegalArgumentException();
                }
            }

            public static VehicleType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return VehicleType.Factory.fromString(content, namespaceUri);
                } else {
                    return VehicleType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static VehicleType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                VehicleType object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                            if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                throw new org.apache.axis2.databinding.ADBException("The element: " + "vehicleType" + "  cannot be null");
                            }

                            java.lang.String content = reader.getElementText();

                            if (content.indexOf(":") > 0) {
                                // this seems to be a Qname so find the namespace and send
                                prefix = content.substring(0, content.indexOf(":"));
                                namespaceuri = reader.getNamespaceURI(prefix);
                                object = VehicleType.Factory.fromString(content, namespaceuri);
                            } else {
                                            // this seems to be not a qname send and empty namespace incase of it is
                                // check is done in fromString method
                                object = VehicleType.Factory.fromString(content, "");
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class PinkSlipFaultType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://phanh.se/services",
                "pinkSlipFaultType",
                "ns1");

        /**
         * field for PinkSlipFaultType
         */
        protected java.lang.String localPinkSlipFaultType;

        private static java.util.HashMap _table_ = new java.util.HashMap();

                            // Constructor
        protected PinkSlipFaultType(java.lang.String value, boolean isRegisterValue) {
            localPinkSlipFaultType = value;
            if (isRegisterValue) {

                _table_.put(localPinkSlipFaultType, this);

            }

        }

        public static final java.lang.String _DriverNotFound
                = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DriverNotFound");

        public static final java.lang.String _VehicleNotFound
                = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("VehicleNotFound");

        public static final java.lang.String _InvalidFirstName
                = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidFirstName");

        public static final java.lang.String _InvalidLastName
                = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidLastName");

        public static final java.lang.String _InvalidRegistrationNumber
                = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("InvalidRegistrationNumber");

        public static final PinkSlipFaultType DriverNotFound
                = new PinkSlipFaultType(_DriverNotFound, true);

        public static final PinkSlipFaultType VehicleNotFound
                = new PinkSlipFaultType(_VehicleNotFound, true);

        public static final PinkSlipFaultType InvalidFirstName
                = new PinkSlipFaultType(_InvalidFirstName, true);

        public static final PinkSlipFaultType InvalidLastName
                = new PinkSlipFaultType(_InvalidLastName, true);

        public static final PinkSlipFaultType InvalidRegistrationNumber
                = new PinkSlipFaultType(_InvalidRegistrationNumber, true);

        public java.lang.String getValue() {
            return localPinkSlipFaultType;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj == this);
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public java.lang.String toString() {

            return localPinkSlipFaultType.toString();

        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

                //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://phanh.se/services");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":pinkSlipFaultType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "pinkSlipFaultType",
                            xmlWriter);
                }
            }

            if (localPinkSlipFaultType == null) {

                throw new org.apache.axis2.databinding.ADBException("pinkSlipFaultType cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localPinkSlipFaultType);

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://phanh.se/services")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPinkSlipFaultType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static PinkSlipFaultType fromValue(java.lang.String value)
                    throws java.lang.IllegalArgumentException {
                PinkSlipFaultType enumeration = (PinkSlipFaultType) _table_.get(value);

                if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                    throw new java.lang.IllegalArgumentException();
                }
                return enumeration;
            }

            public static PinkSlipFaultType fromString(java.lang.String value, java.lang.String namespaceURI)
                    throws java.lang.IllegalArgumentException {
                try {

                    return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                } catch (java.lang.Exception e) {
                    throw new java.lang.IllegalArgumentException();
                }
            }

            public static PinkSlipFaultType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return PinkSlipFaultType.Factory.fromString(content, namespaceUri);
                } else {
                    return PinkSlipFaultType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static PinkSlipFaultType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                PinkSlipFaultType object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                            if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                throw new org.apache.axis2.databinding.ADBException("The element: " + "pinkSlipFaultType" + "  cannot be null");
                            }

                            java.lang.String content = reader.getElementText();

                            if (content.indexOf(":") > 0) {
                                // this seems to be a Qname so find the namespace and send
                                prefix = content.substring(0, content.indexOf(":"));
                                namespaceuri = reader.getNamespaceURI(prefix);
                                object = PinkSlipFaultType.Factory.fromString(content, namespaceuri);
                            } else {
                                            // this seems to be not a qname send and empty namespace incase of it is
                                // check is done in fromString method
                                object = PinkSlipFaultType.Factory.fromString(content, "");
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class CheckedFlag
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://phanh.se/services",
                "checkedFlag",
                "ns1");

        /**
         * field for CheckedFlag
         */
        protected java.lang.String localCheckedFlag;

        private static java.util.HashMap _table_ = new java.util.HashMap();

                            // Constructor
        protected CheckedFlag(java.lang.String value, boolean isRegisterValue) {
            localCheckedFlag = value;
            if (isRegisterValue) {

                _table_.put(localCheckedFlag, this);

            }

        }

        public static final java.lang.String _Yes
                = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Yes");

        public static final java.lang.String _No
                = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("No");

        public static final CheckedFlag Yes
                = new CheckedFlag(_Yes, true);

        public static final CheckedFlag No
                = new CheckedFlag(_No, true);

        public java.lang.String getValue() {
            return localCheckedFlag;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj == this);
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public java.lang.String toString() {

            return localCheckedFlag.toString();

        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                javax.xml.stream.XMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

                //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://phanh.se/services");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":checkedFlag",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "checkedFlag",
                            xmlWriter);
                }
            }

            if (localCheckedFlag == null) {

                throw new org.apache.axis2.databinding.ADBException("checkedFlag cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localCheckedFlag);

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://phanh.se/services")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCheckedFlag)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static CheckedFlag fromValue(java.lang.String value)
                    throws java.lang.IllegalArgumentException {
                CheckedFlag enumeration = (CheckedFlag) _table_.get(value);

                if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                    throw new java.lang.IllegalArgumentException();
                }
                return enumeration;
            }

            public static CheckedFlag fromString(java.lang.String value, java.lang.String namespaceURI)
                    throws java.lang.IllegalArgumentException {
                try {

                    return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                } catch (java.lang.Exception e) {
                    throw new java.lang.IllegalArgumentException();
                }
            }

            public static CheckedFlag fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return CheckedFlag.Factory.fromString(content, namespaceUri);
                } else {
                    return CheckedFlag.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static CheckedFlag parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                CheckedFlag object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                            if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                throw new org.apache.axis2.databinding.ADBException("The element: " + "checkedFlag" + "  cannot be null");
                            }

                            java.lang.String content = reader.getElementText();

                            if (content.indexOf(":") > 0) {
                                // this seems to be a Qname so find the namespace and send
                                prefix = content.substring(0, content.indexOf(":"));
                                namespaceuri = reader.getNamespaceURI(prefix);
                                object = CheckedFlag.Factory.fromString(content, namespaceuri);
                            } else {
                                            // this seems to be not a qname send and empty namespace incase of it is
                                // check is done in fromString method
                                object = CheckedFlag.Factory.fromString(content, "");
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    private org.apache.axiom.om.OMElement toOM(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.Driver param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.Driver.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.VehicleInfoResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.VehicleInfoResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PinkSlipFault param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PinkSlipFault.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PSCheckResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PSCheckResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.Driver param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.Driver.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */
    /**
     * get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(
            org.apache.axiom.om.OMElement param,
            java.lang.Class type,
            java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {

        try {

            if (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.Driver.class.equals(type)) {

                return au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.Driver.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.VehicleInfoResponse.class.equals(type)) {

                return au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.VehicleInfoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PinkSlipFault.class.equals(type)) {

                return au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PinkSlipFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.Driver.class.equals(type)) {

                return au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.Driver.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PSCheckResponse.class.equals(type)) {

                return au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PSCheckResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PinkSlipFault.class.equals(type)) {

                return au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PinkSlipFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }

}
