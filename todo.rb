#!/home/jarrod/.rvm/rubies/ruby-2.1.2/bin/ruby
# This script scans java files and outputs comments of form // TODO:
# to and output file where all tasks can be viewed and managed.

def extract_todo inputFile, outputFile
	count = 0
	inputFile.each_line do |line|
		if (line.include? "// TODO")
			line = line.gsub("\// TODO:", "").strip
			outputFile.puts "#{inputFile.lineno}: #{line}"
			count += 1
		end
	end
		
	if (count == 0)
		outputFile.puts "Nothing to do here!"
	end
end

def print_header outputFile
	time = Time.new
	outputFile.puts "************************************************************************************"
	outputFile.puts "*  TODO LIST CSC 4101                     Last Updated: #{time}  *"
	outputFile.puts "************************************************************************************"
	outputFile.puts
end

outputFile = File.open("todo.txt", "w")
filePath = File.dirname(__FILE__)

print_header outputFile

Dir.foreach(filePath) do |item|
	if (item.include? ".java")
		inputFile = File.open(item, "r")
		fileName = File.basename("#{filePath}/#{item}")

		outputFile.puts fileName
		outputFile.puts "-----------------------------------"
		
		extract_todo inputFile, outputFile

		outputFile.puts
		inputFile.close()
	end
end

outputFile.close()
