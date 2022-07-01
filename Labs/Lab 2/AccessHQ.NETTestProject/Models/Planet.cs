using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccessHQ.NETTestProject.Models
{
    internal class Planet
    {
        private WebElement planetWebElement;

        public Planet(WebElement planetWebElement)
        {
            this.planetWebElement = planetWebElement;
        }

        public String getName()
        {
            return planetWebElement.FindElement(By.ClassName("name")).Text.ToLower();
        }

        public void ClickExplore()
        {
            planetWebElement.FindElement(By.TagName("button")).Click();
        }
    }
}
