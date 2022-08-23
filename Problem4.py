from datetime import datetime
import re

dates = ["21 Jun 2018", "22 Dec 2019", "05 Nov 2006"]
dates.sort(key=lambda date: datetime.strptime(date, '%d %b %Y'))
print(dates)