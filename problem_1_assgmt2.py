from selenium import webdriver
import configparser
import time
from msedge.selenium_tools import EdgeOptions
from msedge.selenium_tools import Edge

PROXY = "8.8.8.8:8080"  #enter the proxy ip and port

def launch_browser():
    """
    Loading and assigning global variables from our settings.txt file
    """
    config_parser = configparser.RawConfigParser()   #to read data from settings file
    config_file_path = r'C:\Users\gmandeep\PycharmProjects\DS_practice\PTN_report\assignment\New folder\settings.txt' #replace the file path of settings.txt
    config_parser.read(config_file_path)
    time.sleep(2)
    browserName = config_parser.get('config', 'BROWSER')
    page = config_parser.get('config', 'PAGE')

    if browserName == 'firefox':
        profile = webdriver.FirefoxProfile()
        firefox_opt = webdriver.FirefoxOptions()
        firefox_opt.accept_insecure_certs = True
        firefox_opt.headless = False   # set it to True to run in headless mode
        firefox_opt.add_argument("--disable-notifications")   #used to disable unnessary notification on the browser
        firefox_opt.add_argument("--allow-running-insecure-content")
        firefox_opt.add_argument("--ignore-certificate-errors")  #handle SSL error caused on the browser
        firefox_opt.add_argument('start-maximized')    #maximize the browser screen
        firefox_opt.add_argument("--window-size=1920,1080")    #manage browser capabilities
        firefox_opt.add_argument("--enable-precise-memory-info")  #manage browser capabilities
        firefox_opt.add_argument("--disable-popup-blocking")
        firefox_opt.add_argument("--disable-notifications")
        firefox_opt.add_argument('--proxy-server=%s' % PROXY)   #handle proxy server
        driver = webdriver.Firefox(firefox_profile=profile, options=firefox_opt)
    elif browserName == 'chrome':
        Options = webdriver.ChromeOptions()
        Options.add_argument("--disable-notifications")
        Options.add_argument("--allow-running-insecure-content")
        Options.add_argument("--ignore-certificate-errors")
        Options.headless = False     # set it to True to run in headless mode
        Options.add_argument('start-maximized')
        Options.add_argument("--window-size=1920,1080")
        Options.add_argument("--enable-precise-memory-info")
        Options.add_argument("--disable-popup-blocking")
        Options.add_argument('--proxy-server=%s' % PROXY)
        driver = webdriver.Chrome(options=Options)
    elif browserName == 'edge':
        edge_options = EdgeOptions()
        edge_options.use_chromium = True
        edge_options.headless = False   # set it to True to run in headless mode
        edge_options.add_argument("--disable-notifications")
        edge_options.add_argument("--allow-running-insecure-content")
        edge_options.add_argument("--ignore-certificate-errors")
        edge_options.add_argument('start-maximized')
        edge_options.add_argument("--window-size=1920,1080")
        edge_options.add_argument("--enable-precise-memory-info")
        edge_options.add_argument("--disable-popup-blocking")
        edge_options.add_argument('--proxy-server=%s' % PROXY)
        driver = Edge(options=edge_options)
    else:
        print("No browser is specified")
    driver.get(page)
    driver.implicitly_wait(10)
    return driver

launch_browser()
