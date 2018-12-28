/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.airavata.workflow.model.wf;

import org.apache.airavata.common.utils.XMLUtil;

//import xsul5.wsdl.WsdlDefinitions;

public class TridentTransformer {

//    public void process(WsdlDefinitions wsdl) {
//        XmlElement types = wsdl.getTypes();
//        Iterable<XmlElement> schemas = types.elements(null, "schema");
//        LinkedList<XmlElement> removeList = new LinkedList<XmlElement>();
//        for (XmlElement schema : schemas) {
//            String tns = schema.attributeValue("targetNamespace");
//            if (null != tns && -1 != tns.indexOf("http://www.extreme.indiana.edu/xbaya")) {
//            } else {
//                removeList.add(schema);
//            }
//        }
//        for (XmlElement schema : removeList) {
//            types.removeChild(schema);
//        }
//
//        types.addChild(XMLUtil.stringToXmlElement(GFacSimpleTypesXSD.XSD));
//        types.addChild(XMLUtil.stringToXmlElement(LeadCrosscutXSD.XSD));
//        types.addChild(XMLUtil.stringToXmlElement(LeadContextHeaderXSD.XSD));
//
//        XmlElement xml = wsdl.xml();
//        XMLUtil.removeElements(xml, "partnerLinkType");
//        XMLUtil.removeElements(xml, "default");
//
//    }

}