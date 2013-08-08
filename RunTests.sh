#!/bin/bash

rm -f se254/money/*.class 	#remove the previous compiled classes
rm -f outputs/*.txt	#remove all previous log files
javac -cp "./junit.jar:./se254/badA.jar" ./se254/money/TestMoney.java				#compiled TestMoney.java using badA.jar
java -cp ".:./junit.jar:./se254/badA.jar" se254.money.TestMoney >./outputs/badA.txt		#run the compiled TestMoney class and write the output into file badA.txt
echo "badA complete."
javac -cp "./junit.jar:./se254/badB.jar" ./se254/money/TestMoney.java				#compiled TestMoney.java using badB.jar
java -cp ".:./junit.jar:./se254/badB.jar" se254.money.TestMoney >./outputs/badB.txt		#run the compiled TestMoney class and write the output into file badB.txt
echo "badB complete."
javac -cp "./junit.jar:./se254/badC.jar" ./se254/money/TestMoney.java				#compiled TestMoney.java using badC.jar
java -cp ".:./junit.jar:./se254/badC.jar" se254.money.TestMoney >./outputs/badC.txt		#run the compiled TestMoney class and write the output into file badC.txt
echo "badC complete."
javac -cp "./junit.jar:./se254/badD.jar" ./se254/money/TestMoney.java				#compiled TestMoney.java using badD.jar
java -cp ".:./junit.jar:./se254/badD.jar" se254.money.TestMoney >./outputs/badD.txt		#run the compiled TestMoney class and write the output into file badD.txt
echo "badD complete."
javac -cp "./junit.jar:./se254/badE.jar" ./se254/money/TestMoney.java				#compiled TestMoney.java using badE.jar
java -cp ".:./junit.jar:./se254/badE.jar" se254.money.TestMoney >./outputs/badE.txt		#run the compiled TestMoney class and write the output into file badE.txt
echo "badE complete."
javac -cp "./junit.jar:./se254/badF.jar" ./se254/money/TestMoney.java				#compiled TestMoney.java using badF.jar
java -cp ".:./junit.jar:./se254/badF.jar" se254.money.TestMoney >./outputs/badF.txt		#run the compiled TestMoney class and write the output into file badF.txt
echo "badF complete."
javac -cp "./junit.jar:./se254/badG.jar" ./se254/money/TestMoney.java				#compiled TestMoney.java using badG.jar
java -cp ".:./junit.jar:./se254/badG.jar" se254.money.TestMoney >./outputs/badG.txt		#run the compiled TestMoney class and write the output into file badG.txt
echo "badG complete."
javac -cp "./junit.jar:./se254/badH.jar" ./se254/money/TestMoney.java				#compiled TestMoney.java using badH.jar
java -cp ".:./junit.jar:./se254/badH.jar" se254.money.TestMoney >./outputs/badH.txt		#run the compiled TestMoney class and write the output into file badH.txt
echo "badH complete."
javac -cp "./junit.jar:./se254/badI.jar" ./se254/money/TestMoney.java				#compiled TestMoney.java using badI.jar
java -cp ".:./junit.jar:./se254/badI.jar" se254.money.TestMoney >./outputs/badI.txt		#run the compiled TestMoney class and write the output into file badI.txt
echo "badI complete."
javac -cp "./junit.jar:./se254/badJ.jar" ./se254/money/TestMoney.java				#compiled TestMoney.java using badJ.jar
java -cp ".:./junit.jar:./se254/badJ.jar" se254.money.TestMoney >./outputs/badJ.txt		#run the compiled TestMoney class and write the output into file badJ.txt
echo "badJ complete."
javac -cp "./junit.jar:./se254/good.jar" ./se254/money/TestMoney.java				#compiled TestMoney.java using good.jar
java -cp ".:./junit.jar:./se254/good.jar" se254.money.TestMoney >./outputs/good.txt		#run the compiled TestMoney class and write the output into file good.txt
echo "good complete."