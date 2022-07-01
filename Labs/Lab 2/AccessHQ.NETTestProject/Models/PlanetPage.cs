using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccessHQ.NETTestProject.Models
{
    internal class PlanetPage
    {
        private WebDriver driver;

        public PlanetPage(WebDriver driver)
        {
            this.driver = driver;
        }

        public void clickExplore(Predicate<Planet> strategy)
        {
            foreach (Planet planet in GetPlanets())
            {
                if (strategy.Invoke(planet))
                {
                    clickExploreButton(planet);
                }
            }
        }

        private void clickExploreButton(Planet planet)
        {
            planet.ClickExplore();
        }

        public WebElement getPopUpElement()
        {
            return (WebElement)driver.FindElement(By.ClassName("popup-message"));
        }
        public void waitForPopUp()
        {
            var popup = driver.FindElement(By.ClassName("popup-message"));
            new WebDriverWait(driver, TimeSpan.FromSeconds(10)).Until(d=>
                d.FindElement(By.ClassName("popup-message")).Displayed);
        }

        public List<Planet> GetPlanets()
        {
            List<Planet> planets = new List<Planet>();
            
             foreach(WebElement currentWebElement in driver.FindElements(By.ClassName("planet")))
            {
                planets.Add(new Planet(currentWebElement)); 
            }

            return planets;

        }

    }
}
