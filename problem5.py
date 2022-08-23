import glob
import os
import shutil

file_path1 = r'C:\Users\gmandeep\Documents\important docs\New folder\*'
file_path2 = r"C:\Users\gmandeep\PycharmProjects\DS_practice\UATZETA\UATZETA_1"

list_of_files = glob.glob(file_path1)
try:
    latest_file = max(list_of_files, key=os.path.getctime)
    print (latest_file)
    print("moving the file to new directory")
    shutil.move(latest_file, file_path2)
except ValueError:
    print("No files found in this location")