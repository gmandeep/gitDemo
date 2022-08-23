import pandas as pd
import chardet
import re
import collections

expected_col = ['timestamp', 'sessionid', 'sender_name', 'sender_number', 'receiver_name', 'receiver_number', 'message_mode', 'message_type', 'content_type', 'count', 'participants_list', 'message_platform', 'business_identifier']
sessionID1 = "c184965e-5b72-42c5-90fb-4708663746f8"
excel_file2 = 'Message-Activity-Report-2021-05-30To2021-05-31-org 4000-2021-06-02-06-08-00-0400.csv'
receiver_number1 = "14842843119"
message_mode = "Data"
message_type = "OUT"

with open(excel_file2, 'rb') as f:
    result = chardet.detect(f.read())
df1 = pd.read_csv(excel_file2, encoding=result['encoding'], engine='c', error_bad_lines=False)
no_rows= len(df1)

print( "total number of records present in the CSV are: "+ str(no_rows),  '\n')
column_head = list(df1.columns)
print("list of fields present in the CALL API CSV REPORT are: " + str(column_head),  '\n')

print("check all fields are present")
if column_head == expected_col :
    print("all expected fields are present")
else:
    print("all expected fields are not present")

#option 2
if collections.Counter(column_head) == collections.Counter(expected_col):
    print ("all expected fields are present")
else:
    print ("all expected fields are not present")

#b.	Validate that all the session ids are unique
all_session_id = df1['sessionid'].tolist()
print(all_session_id)
unique_sessionid = []
repeated_sessionid = []
for i in all_session_id:
    if i not in unique_sessionid:
        unique_sessionid.append(i)
    else:
        repeated_sessionid.append(i)

if len(repeated_sessionid) == 0:
    print("all session IDs are unique")
else:
    print("the repeated session IDs are", repeated_sessionid)

#c.	Validate that for session id “c184965e-5b72-42c5-90fb-4708663746f8” , the receiver number is “14842843119”, message mode is “data” and message type is “OUT

try:
    out1 = (df1[df1['sessionid'] == sessionID1])
    out1 = str(out1)
    s = "(\d+)\s+\d+\-\d+\-\d+T"
    m = re.findall(s,out1)
    cdr_row = int(m[0])
    print("call record row in the CSV", cdr_row)
#checking receiver number
    receiver_num = df1['receiver_number'].values[cdr_row]
    print("receiver_num in report for this call is", receiver_num)
    if str(receiver_num) == receiver_number1:
        print("receiver_number matched with the requirement", '\n')
    else:
        print("receiver_number did not match with the requirement", '\n')
#checking message mode
    msg_mode = df1['message_mode'].values[cdr_row]
    print("message_mode in report for this call is", msg_mode)
    if str(msg_mode) == message_mode:
        print("message_mode matched with the requirement", '\n')
    else:
        print("message_mode did not match with the requirement", '\n')
#checking message type
    msg_type = df1['message_type'].values[cdr_row]
    print("message_type in report for this call is", msg_type)
    if str(msg_type) == message_type:
        print("message_type matched with the requirement", '\n')
    else:
        print("message_type did not match with the requirement", '\n')

except:
    print("session ID not present in the file", '\n')
