from selenium import webdriver
import unittest
import HtmlTestRunner
import time
from selenium.webdriver.support.ui import Select
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from datetime import date
from datetime import datetime
from datetime import timedelta


url = "https://www.sakraworldhospital.com/request-appointment.php"
name = "ramesh kr"
email_id  = "ramesh_12345@gmail.com"
mobile_number = "9180100711"
DOB =  "04/03/1990"

#to check current date and create a appointment Date of 10 day later
dt_stamp = date.today()
new =datetime.strptime(str(dt_stamp), "%Y-%m-%d")
Enddate = new + timedelta(days=10)
appoint_date_1 = Enddate.strftime('%m/%d/%Y')

class sakra_Test(unittest.TestCase):

    @classmethod
    def setUpClass(cls) :
        options = webdriver.ChromeOptions()
        options.add_argument("start-maximized")
        options.add_argument('disable-infobars')
        cls.driver = webdriver.Chrome(executable_path="C:\python3.7\Scripts\chromedriver.exe", options =options)
        cls.driver.maximize_window()

    def test_login_page_submission(self):
        self.driver.get(url)
        time.sleep(10)
        test = self.driver.find_element_by_xpath("//*[contains(text(), 'Dr. Shishir Chandrashekhar')]")
        self.driver.execute_script('arguments[0].click()', test)
        time.sleep(5)
        accept_consult = self.driver.find_element_by_xpath("//*[@id='hv-vc-appointment-pop-up105']/div/div/div[2]/div/p[2]/button[1]")
        self.driver.execute_script('arguments[0].click()', accept_consult)
        time.sleep(5)
        name1 = self.driver.find_element_by_name("req_name")  #enter name of patient
        name1.send_keys(name)
        time.sleep(2)
        email = self.driver.find_element_by_name("req_email")   #enter email of patient
        email.send_keys(email_id)
        time.sleep(2)
        phone_number = self.driver.find_element_by_name("req_mobile")  #enter phoe number of patient
        phone_number.send_keys(mobile_number)
        gender = Select(self.driver.find_element_by_id("req_gender"))  #enter gender of patient
        gender.select_by_value("1")
        dob = self.driver.find_element_by_name("req_datebirth")   #enter DOB of patient
        dob.send_keys(DOB)
        appoint_1 = self.driver.find_element_by_name("req_prefdate1")  #fill appointment 1 date 10 days after today
        appoint_1.send_keys(appoint_date_1)
        time.sleep(5)
#check the visibility of elements
        name_1 = self.driver.find_element_by_class_name("label-text")
        if name_1.is_displayed():
            print("name element is present")
        else:
            print("name element is not present")
        date_1 = self.driver.find_element_by_xpath("(//*[@id= 'datetimepicker1'])[2]")
        if date_1.is_displayed():
            print("date 1 element is present")
        else:
            print("date 2 element is not present")
# check and click captcha
        WebDriverWait(self.driver, 30).until(EC.frame_to_be_available_and_switch_to_it((By.CSS_SELECTOR, "iframe[name^='a-'][src^='https://www.google.com/recaptcha/api2/anchor?']")))
        captcha = WebDriverWait(self.driver, 30).until(EC.element_to_be_clickable((By.XPATH, "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']/div[@class='recaptcha-checkbox-checkmark']")))
        self.driver.execute_script('arguments[0].click()', captcha)


    @classmethod
    def tearDownClass(cls):
         cls.driver = webdriver.Chrome(executable_path="C:\python3.7\Scripts\chromedriver.exe")
         time.sleep(20)
         cls.driver.quit()
         print("test completed")


if __name__ == '__main__':
    unittest.main()
  #  unittest.main(testRunner=HtmlTestRunner.HTMLTestRunner(output=r'C:\Users\gmandeep\PycharmProjects\Reports'))