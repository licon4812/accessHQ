using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccessHQ.NETTestProject
{
    internal class Nav
    {
        private WebDriver driver;

        public Nav(WebDriver driver)
        {
            this.driver = driver;            
        }

        public void NavigateToPlanets()
        {
            driver.FindElement(By.CssSelector("a[href='#/planets']")).Click();
        }
    }
}
