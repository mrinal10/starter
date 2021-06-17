package com.JAXBediotr;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "baseel"
})
@XmlRootElement(name = "Mrinal")
public class Mrinal {

    @XmlElement(required = true)
    protected Mrinal.Baseel baseel;
    public Mrinal.Baseel getBaseel() {
        return baseel;
    }

   
    public void setBaseel(Mrinal.Baseel value) {
        this.baseel = value;
    }


    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "testElement",
        "testElement11"
    })
    public static class Baseel {

        @XmlElement(required = true)
        protected Mrinal.Baseel.TestElement testElement;

        @XmlElement(required = true)
        protected Mrinal.Baseel.TestElement11 testElement11;
        @XmlAttribute(name = "newVak")
        protected String newVak;

        
        public Mrinal.Baseel.TestElement getTestElement() {
            return testElement;
        }

       
        public void setTestElement(Mrinal.Baseel.TestElement value) {
            this.testElement = value;
        }

        
        public Mrinal.Baseel.TestElement11 getTestElement11() {
            return testElement11;
        }

       
        public void setTestElement11(Mrinal.Baseel.TestElement11 value) {
            this.testElement11 = value;
        }

       
        public String getNewVak() {
            return newVak;
        }

        
        public void setNewVak(String value) {
            this.newVak = value;
        }


	@XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class TestElement {

            @XmlAttribute(name = "value")
            protected Integer value;

            
            public Integer getValue() {
                return value;
            }

            
            public void setValue(Integer value) {
                this.value = value;
            }

        }


       
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class TestElement11 {

            @XmlAttribute(name = "testValue")
            protected Integer testValue;

           
            public Integer getTestValue() {
                return testValue;
            }

           
            public void setTestValue(Integer value) {
                this.testValue = value;
            }

        }

    }

}

