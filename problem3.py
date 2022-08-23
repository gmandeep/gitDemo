from datetime import date
from datetime import datetime
import re

today = date.today()
print("Today date is: ", today)
current_DT = datetime.utcnow()
today1 = str(current_DT)
print("current Date and Time in UTC is:", current_DT)
exp = '(\d+\-\d+\-\d+)\s(\d+)(\:\d+\:\d+)'
time_atb = re.findall(exp,today1)

time_atb[0] = list (time_atb[0])
date = time_atb[0][0]
hour = time_atb[0][1]
min_sec = time_atb[0][2]
print('date is',date,'\n','hour is',hour,'\n','minutes and seconds',min_sec)