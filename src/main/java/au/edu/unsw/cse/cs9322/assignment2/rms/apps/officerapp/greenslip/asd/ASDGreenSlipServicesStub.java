/**
 * ASDGreenSlipServicesStub.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd;

/*
 *  ASDGreenSlipServicesStub java implementation
 */
public class ASDGreenSlipServicesStub extends org.apache.axis2.client.Stub {

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
        _service = new org.apache.axis2.description.AxisService("ASDGreenSlipServices" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[1];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au", "gSCheck"));
        _service.addOperation(__operation);

        _operations[0] = __operation;

    }

    //populates the faults
    private void populateFaults() {

        faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au", "GreenSlipServicesGSCheckFaultException"), "GSCheck"), "au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.GreenSlipServicesGSCheckFaultExceptionException");
        faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au", "GreenSlipServicesGSCheckFaultException"), "GSCheck"), "au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.GreenSlipServicesGSCheckFaultExceptionException");
        faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au", "GreenSlipServicesGSCheckFaultException"), "GSCheck"), "au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub$GreenSlipServicesGSCheckFaultException");

    }

    /**
     * Constructor that takes in a configContext
     */
    public ASDGreenSlipServicesStub(org.apache.axis2.context.ConfigurationContext configurationContext,
            java.lang.String targetEndpoint)
            throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext and useseperate listner
     */
    public ASDGreenSlipServicesStub(org.apache.axis2.context.ConfigurationContext configurationContext,
            java.lang.String targetEndpoint, boolean useSeparateListener)
            throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

        //Set the soap version
        _serviceClient.getOptions().setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);

    }

    /**
     * Default Constructor
     */
    public ASDGreenSlipServicesStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {

        this(configurationContext, "http://localhost:8080/axis2/services/ASD/GreenSlipServices.GreenSlipServicesHttpSoap12Endpoint/");

    }

    /**
     * Default Constructor
     */
    public ASDGreenSlipServicesStub() throws org.apache.axis2.AxisFault {

        this("http://localhost:8080/axis2/services/ASD/GreenSlipServices.GreenSlipServicesHttpSoap12Endpoint/");

    }

    /**
     * Constructor taking the target endpoint
     */
    public ASDGreenSlipServicesStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    /**
     * Auto generated method signature
     *
     * @see
     * au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServices#gSCheck
     * @param gSCheck
     *
     * @throws
     * au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.GreenSlipServicesGSCheckFaultExceptionException
     * :
     */
    public au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheckResponseE gSCheck(
            au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheck gSCheck)
            throws java.rmi.RemoteException, au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.GreenSlipServicesGSCheckFaultExceptionException {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions().setAction("urn:GSCheck");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    gSCheck,
                    optimizeContent(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au",
                                    "gSCheck")), new javax.xml.namespace.QName("http://comp9322.unsw.edu.au",
                            "gSCheck"));

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
                    au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheckResponseE.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheckResponseE) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "GSCheck"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "GSCheck"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "GSCheck"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});

                        if (ex instanceof au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.GreenSlipServicesGSCheckFaultExceptionException) {
                            throw (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.GreenSlipServicesGSCheckFaultExceptionException) ex;
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

    //http://localhost:8080/axis2/services/ASD/GreenSlipServices.GreenSlipServicesHttpSoap12Endpoint/
    public static class GSCheckResponse
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
         name = GSCheckResponse
         Namespace URI = http://comp9322.unsw.edu.au/xsd
         Namespace Prefix = ns2
         */

        /**
         * field for DriverCar
         */
        protected Car localDriverCar;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localDriverCarTracker = false;

        public boolean isDriverCarSpecified() {
            return localDriverCarTracker;
        }

        /**
         * Auto generated getter method
         *
         * @return Car
         */
        public Car getDriverCar() {
            return localDriverCar;
        }

        /**
         * Auto generated setter method
         *
         * @param param DriverCar
         */
        public void setDriverCar(Car param) {
            localDriverCarTracker = true;

            this.localDriverCar = param;

        }

        /**
         * field for PaidFlag
         */
        protected boolean localPaidFlag;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localPaidFlagTracker = false;

        public boolean isPaidFlagSpecified() {
            return localPaidFlagTracker;
        }

        /**
         * Auto generated getter method
         *
         * @return boolean
         */
        public boolean getPaidFlag() {
            return localPaidFlag;
        }

        /**
         * Auto generated setter method
         *
         * @param param PaidFlag
         */
        public void setPaidFlag(boolean param) {
            localPaidFlagTracker = true;

            this.localPaidFlag = param;

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
                    = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
            return factory.createOMElement(dataSource, parentQName);

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

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://comp9322.unsw.edu.au/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":GSCheckResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "GSCheckResponse",
                            xmlWriter);
                }

            }
            if (localDriverCarTracker) {
                if (localDriverCar == null) {

                    writeStartElement(null, "http://comp9322.unsw.edu.au/xsd", "driverCar", xmlWriter);

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    localDriverCar.serialize(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au/xsd", "driverCar"),
                            xmlWriter);
                }
            }
            if (localPaidFlagTracker) {
                namespace = "http://comp9322.unsw.edu.au/xsd";
                writeStartElement(null, namespace, "paidFlag", xmlWriter);

                if (false) {

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPaidFlag));
                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://comp9322.unsw.edu.au/xsd")) {
                return "ns2";
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

            if (localDriverCarTracker) {
                elementList.add(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au/xsd",
                        "driverCar"));

                elementList.add(localDriverCar == null ? null
                        : localDriverCar);
            }
            if (localPaidFlagTracker) {
                elementList.add(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au/xsd",
                        "paidFlag"));

                elementList.add(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPaidFlag));
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
            public static GSCheckResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                GSCheckResponse object
                        = new GSCheckResponse();

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

                            if (!"GSCheckResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (GSCheckResponse) ExtensionMapper.getTypeObject(
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

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://comp9322.unsw.edu.au/xsd", "driverCar").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            object.setDriverCar(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setDriverCar(Car.Factory.parse(reader));

                            reader.next();
                        }
                    } // End of if for expected property start element
                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://comp9322.unsw.edu.au/xsd", "paidFlag").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setPaidFlag(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {

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

    public static class GSCheckFaultException
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
         name = GSCheckFaultException
         Namespace URI = http://exceptions.unsw.edu.au/xsd
         Namespace Prefix = ns3
         */

        /**
         * field for FaultMessage
         */
        protected GSCheckFault localFaultMessage;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localFaultMessageTracker = false;

        public boolean isFaultMessageSpecified() {
            return localFaultMessageTracker;
        }

        /**
         * Auto generated getter method
         *
         * @return GSCheckFault
         */
        public GSCheckFault getFaultMessage() {
            return localFaultMessage;
        }

        /**
         * Auto generated setter method
         *
         * @param param FaultMessage
         */
        public void setFaultMessage(GSCheckFault param) {
            localFaultMessageTracker = true;

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
                    = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
            return factory.createOMElement(dataSource, parentQName);

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

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://exceptions.unsw.edu.au/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":GSCheckFaultException",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "GSCheckFaultException",
                            xmlWriter);
                }

            }
            if (localFaultMessageTracker) {
                if (localFaultMessage == null) {

                    writeStartElement(null, "http://exceptions.unsw.edu.au/xsd", "faultMessage", xmlWriter);

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    localFaultMessage.serialize(new javax.xml.namespace.QName("http://exceptions.unsw.edu.au/xsd", "faultMessage"),
                            xmlWriter);
                }
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://exceptions.unsw.edu.au/xsd")) {
                return "ns3";
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

            if (localFaultMessageTracker) {
                elementList.add(new javax.xml.namespace.QName("http://exceptions.unsw.edu.au/xsd",
                        "faultMessage"));

                elementList.add(localFaultMessage == null ? null
                        : localFaultMessage);
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
            public static GSCheckFaultException parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                GSCheckFaultException object
                        = new GSCheckFaultException();

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

                            if (!"GSCheckFaultException".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (GSCheckFaultException) ExtensionMapper.getTypeObject(
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

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://exceptions.unsw.edu.au/xsd", "faultMessage").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            object.setFaultMessage(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setFaultMessage(GSCheckFault.Factory.parse(reader));

                            reader.next();
                        }
                    } // End of if for expected property start element
                    else {

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

    public static class GSCheck
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://comp9322.unsw.edu.au",
                "GSCheck",
                "ns4");

        /**
         * field for Input_car
         */
        protected Car localInput_car;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localInput_carTracker = false;

        public boolean isInput_carSpecified() {
            return localInput_carTracker;
        }

        /**
         * Auto generated getter method
         *
         * @return Car
         */
        public Car getInput_car() {
            return localInput_car;
        }

        /**
         * Auto generated setter method
         *
         * @param param Input_car
         */
        public void setInput_car(Car param) {
            localInput_carTracker = true;

            this.localInput_car = param;

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

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://comp9322.unsw.edu.au");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":GSCheck",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "GSCheck",
                            xmlWriter);
                }

            }
            if (localInput_carTracker) {
                if (localInput_car == null) {

                    writeStartElement(null, "http://comp9322.unsw.edu.au", "input_car", xmlWriter);

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    localInput_car.serialize(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au", "input_car"),
                            xmlWriter);
                }
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://comp9322.unsw.edu.au")) {
                return "ns4";
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

            if (localInput_carTracker) {
                elementList.add(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au",
                        "input_car"));

                elementList.add(localInput_car == null ? null
                        : localInput_car);
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
            public static GSCheck parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                GSCheck object
                        = new GSCheck();

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

                            if (!"GSCheck".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (GSCheck) ExtensionMapper.getTypeObject(
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

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://comp9322.unsw.edu.au", "input_car").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            object.setInput_car(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setInput_car(Car.Factory.parse(reader));

                            reader.next();
                        }
                    } // End of if for expected property start element
                    else {

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

    public static class GreenSlipServicesGSCheckFaultException
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://comp9322.unsw.edu.au",
                "GreenSlipServicesGSCheckFaultException",
                "ns4");

        /**
         * field for GSCheckFaultException
         */
        protected GSCheckFaultException localGSCheckFaultException;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localGSCheckFaultExceptionTracker = false;

        public boolean isGSCheckFaultExceptionSpecified() {
            return localGSCheckFaultExceptionTracker;
        }

        /**
         * Auto generated getter method
         *
         * @return GSCheckFaultException
         */
        public GSCheckFaultException getGSCheckFaultException() {
            return localGSCheckFaultException;
        }

        /**
         * Auto generated setter method
         *
         * @param param GSCheckFaultException
         */
        public void setGSCheckFaultException(GSCheckFaultException param) {
            localGSCheckFaultExceptionTracker = true;

            this.localGSCheckFaultException = param;

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

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://comp9322.unsw.edu.au");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":GreenSlipServicesGSCheckFaultException",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "GreenSlipServicesGSCheckFaultException",
                            xmlWriter);
                }

            }
            if (localGSCheckFaultExceptionTracker) {
                if (localGSCheckFaultException == null) {

                    writeStartElement(null, "http://comp9322.unsw.edu.au", "GSCheckFaultException", xmlWriter);

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    localGSCheckFaultException.serialize(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au", "GSCheckFaultException"),
                            xmlWriter);
                }
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://comp9322.unsw.edu.au")) {
                return "ns4";
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

            if (localGSCheckFaultExceptionTracker) {
                elementList.add(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au",
                        "GSCheckFaultException"));

                elementList.add(localGSCheckFaultException == null ? null
                        : localGSCheckFaultException);
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
            public static GreenSlipServicesGSCheckFaultException parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                GreenSlipServicesGSCheckFaultException object
                        = new GreenSlipServicesGSCheckFaultException();

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

                            if (!"GreenSlipServicesGSCheckFaultException".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (GreenSlipServicesGSCheckFaultException) ExtensionMapper.getTypeObject(
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

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://comp9322.unsw.edu.au", "GSCheckFaultException").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            object.setGSCheckFaultException(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setGSCheckFaultException(GSCheckFaultException.Factory.parse(reader));

                            reader.next();
                        }
                    } // End of if for expected property start element
                    else {

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

            if ("http://comp9322.unsw.edu.au/xsd".equals(namespaceURI)
                    && "GSCheckResponse".equals(typeName)) {

                return GSCheckResponse.Factory.parse(reader);

            }

            if ("http://exceptions.unsw.edu.au/xsd".equals(namespaceURI)
                    && "GSCheckFaultException".equals(typeName)) {

                return GSCheckFaultException.Factory.parse(reader);

            }

            if ("http://objects.unsw.edu.au/xsd".equals(namespaceURI)
                    && "car".equals(typeName)) {

                return Car.Factory.parse(reader);

            }

            if ("http://exceptions.unsw.edu.au/xsd".equals(namespaceURI)
                    && "GSCheckFault".equals(typeName)) {

                return GSCheckFault.Factory.parse(reader);

            }

            throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }

    }

    public static class Car
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
         name = car
         Namespace URI = http://objects.unsw.edu.au/xsd
         Namespace Prefix = ns1
         */

        /**
         * field for Firstname
         */
        protected java.lang.String localFirstname;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localFirstnameTracker = false;

        public boolean isFirstnameSpecified() {
            return localFirstnameTracker;
        }

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getFirstname() {
            return localFirstname;
        }

        /**
         * Auto generated setter method
         *
         * @param param Firstname
         */
        public void setFirstname(java.lang.String param) {
            localFirstnameTracker = true;

            this.localFirstname = param;

        }

        /**
         * field for Lastname
         */
        protected java.lang.String localLastname;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localLastnameTracker = false;

        public boolean isLastnameSpecified() {
            return localLastnameTracker;
        }

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getLastname() {
            return localLastname;
        }

        /**
         * Auto generated setter method
         *
         * @param param Lastname
         */
        public void setLastname(java.lang.String param) {
            localLastnameTracker = true;

            this.localLastname = param;

        }

        /**
         * field for RegoNumber
         */
        protected java.lang.String localRegoNumber;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localRegoNumberTracker = false;

        public boolean isRegoNumberSpecified() {
            return localRegoNumberTracker;
        }

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
            localRegoNumberTracker = true;

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
                    = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
            return factory.createOMElement(dataSource, parentQName);

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

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://objects.unsw.edu.au/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":car",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "car",
                            xmlWriter);
                }

            }
            if (localFirstnameTracker) {
                namespace = "http://objects.unsw.edu.au/xsd";
                writeStartElement(null, namespace, "firstname", xmlWriter);

                if (localFirstname == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localFirstname);

                }

                xmlWriter.writeEndElement();
            }
            if (localLastnameTracker) {
                namespace = "http://objects.unsw.edu.au/xsd";
                writeStartElement(null, namespace, "lastname", xmlWriter);

                if (localLastname == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localLastname);

                }

                xmlWriter.writeEndElement();
            }
            if (localRegoNumberTracker) {
                namespace = "http://objects.unsw.edu.au/xsd";
                writeStartElement(null, namespace, "regoNumber", xmlWriter);

                if (localRegoNumber == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localRegoNumber);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://objects.unsw.edu.au/xsd")) {
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

            if (localFirstnameTracker) {
                elementList.add(new javax.xml.namespace.QName("http://objects.unsw.edu.au/xsd",
                        "firstname"));

                elementList.add(localFirstname == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFirstname));
            }
            if (localLastnameTracker) {
                elementList.add(new javax.xml.namespace.QName("http://objects.unsw.edu.au/xsd",
                        "lastname"));

                elementList.add(localLastname == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastname));
            }
            if (localRegoNumberTracker) {
                elementList.add(new javax.xml.namespace.QName("http://objects.unsw.edu.au/xsd",
                        "regoNumber"));

                elementList.add(localRegoNumber == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRegoNumber));
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
            public static Car parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Car object
                        = new Car();

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

                            if (!"car".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Car) ExtensionMapper.getTypeObject(
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

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://objects.unsw.edu.au/xsd", "firstname").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setFirstname(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://objects.unsw.edu.au/xsd", "lastname").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setLastname(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://objects.unsw.edu.au/xsd", "regoNumber").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setRegoNumber(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {

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

    public static class GSCheckFault
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
         name = GSCheckFault
         Namespace URI = http://exceptions.unsw.edu.au/xsd
         Namespace Prefix = ns3
         */

        /**
         * field for Error_message
         */
        protected java.lang.String localError_message;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localError_messageTracker = false;

        public boolean isError_messageSpecified() {
            return localError_messageTracker;
        }

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getError_message() {
            return localError_message;
        }

        /**
         * Auto generated setter method
         *
         * @param param Error_message
         */
        public void setError_message(java.lang.String param) {
            localError_messageTracker = true;

            this.localError_message = param;

        }

        /**
         * field for Error_type
         */
        protected java.lang.String localError_type;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localError_typeTracker = false;

        public boolean isError_typeSpecified() {
            return localError_typeTracker;
        }

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getError_type() {
            return localError_type;
        }

        /**
         * Auto generated setter method
         *
         * @param param Error_type
         */
        public void setError_type(java.lang.String param) {
            localError_typeTracker = true;

            this.localError_type = param;

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
                    = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
            return factory.createOMElement(dataSource, parentQName);

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

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://exceptions.unsw.edu.au/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":GSCheckFault",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "GSCheckFault",
                            xmlWriter);
                }

            }
            if (localError_messageTracker) {
                namespace = "http://exceptions.unsw.edu.au/xsd";
                writeStartElement(null, namespace, "error_message", xmlWriter);

                if (localError_message == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localError_message);

                }

                xmlWriter.writeEndElement();
            }
            if (localError_typeTracker) {
                namespace = "http://exceptions.unsw.edu.au/xsd";
                writeStartElement(null, namespace, "error_type", xmlWriter);

                if (localError_type == null) {
                    // write the nil attribute

                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localError_type);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://exceptions.unsw.edu.au/xsd")) {
                return "ns3";
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

            if (localError_messageTracker) {
                elementList.add(new javax.xml.namespace.QName("http://exceptions.unsw.edu.au/xsd",
                        "error_message"));

                elementList.add(localError_message == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localError_message));
            }
            if (localError_typeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://exceptions.unsw.edu.au/xsd",
                        "error_type"));

                elementList.add(localError_type == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localError_type));
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
            public static GSCheckFault parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                GSCheckFault object
                        = new GSCheckFault();

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

                            if (!"GSCheckFault".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (GSCheckFault) ExtensionMapper.getTypeObject(
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

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://exceptions.unsw.edu.au/xsd", "error_message").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setError_message(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://exceptions.unsw.edu.au/xsd", "error_type").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                            java.lang.String content = reader.getElementText();

                            object.setError_type(
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if any.
                        }

                        reader.next();

                    } // End of if for expected property start element
                    else {

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

    public static class GSCheckResponseE
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://comp9322.unsw.edu.au",
                "GSCheckResponse",
                "ns4");

        /**
         * field for _return
         */
        protected GSCheckResponse local_return;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean local_returnTracker = false;

        public boolean is_returnSpecified() {
            return local_returnTracker;
        }

        /**
         * Auto generated getter method
         *
         * @return GSCheckResponse
         */
        public GSCheckResponse get_return() {
            return local_return;
        }

        /**
         * Auto generated setter method
         *
         * @param param _return
         */
        public void set_return(GSCheckResponse param) {
            local_returnTracker = true;

            this.local_return = param;

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

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://comp9322.unsw.edu.au");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":GSCheckResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "GSCheckResponse",
                            xmlWriter);
                }

            }
            if (local_returnTracker) {
                if (local_return == null) {

                    writeStartElement(null, "http://comp9322.unsw.edu.au", "return", xmlWriter);

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    local_return.serialize(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au", "return"),
                            xmlWriter);
                }
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://comp9322.unsw.edu.au")) {
                return "ns4";
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

            if (local_returnTracker) {
                elementList.add(new javax.xml.namespace.QName("http://comp9322.unsw.edu.au",
                        "return"));

                elementList.add(local_return == null ? null
                        : local_return);
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
            public static GSCheckResponseE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                GSCheckResponseE object
                        = new GSCheckResponseE();

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

                            if (!"GSCheckResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (GSCheckResponseE) ExtensionMapper.getTypeObject(
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

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://comp9322.unsw.edu.au", "return").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            object.set_return(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.set_return(GSCheckResponse.Factory.parse(reader));

                            reader.next();
                        }
                    } // End of if for expected property start element
                    else {

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

    private org.apache.axiom.om.OMElement toOM(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheck param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheck.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheckResponseE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheckResponseE.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GreenSlipServicesGSCheckFaultException param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GreenSlipServicesGSCheckFaultException.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheck param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheck.MY_QNAME, factory));
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

            if (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheck.class.equals(type)) {

                return au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheck.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheckResponseE.class.equals(type)) {

                return au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheckResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if (au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GreenSlipServicesGSCheckFaultException.class.equals(type)) {

                return au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GreenSlipServicesGSCheckFaultException.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }

}
