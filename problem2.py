import os

txt = "Movius is the leading global provider in cloud-based secure mobile communications software, helping enterprises deliver better engagement for their clients. Enterprises around the world use the company's all-in-one mobility platform to connect with their customers in more convenient, cost-effective and compliant ways."

f = open("problem2_output.txt", "w")
f.write(txt+ '\n')
f.close()

txt = txt.split(" ")
split_list = []
for i in txt:
    if i not in split_list:
        split_list.append(i)
out_without_rep = ' '.join(split_list)
f = open("problem2_output.txt", "a")
f.write(out_without_rep)