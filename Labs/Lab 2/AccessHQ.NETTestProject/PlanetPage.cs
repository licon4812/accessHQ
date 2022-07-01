using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccessHQ.NETTestProject
{
    internal class PlanetPage
    {
        private WebDriver driver;

        public PlanetPage(WebDriver driver)
        {
            this.driver = driver;
        }

        public void clickExplore()
        {
            foreach (WebElement currentElement in driver.FindElements(By.ClassName("planet")))
            {
                if (currentElement.FindElement(By.ClassName("name")).Text == "Earth")
                {
                    currentElement.FindElement(By.TagName("button")).Click();
                }
            }
        }

        public WebElement getPopUpElement()
        {
            return (WebElement)driver.FindElement(By.ClassName("popup-message"));
        }
        public void waitForPopUp()
        {
            var popup = getPopUpElement();
            new WebDriverWait(driver, new TimeSpan(1)).Until(d=> getPopUpElement().Displayed);
        }

    }
}
