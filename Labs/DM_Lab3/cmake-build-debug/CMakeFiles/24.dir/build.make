# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.15

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /snap/clion/98/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /snap/clion/98/bin/cmake/linux/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/kruxx/git/Study/Labs/DM_Lab3

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/kruxx/git/Study/Labs/DM_Lab3/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/24.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/24.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/24.dir/flags.make

CMakeFiles/24.dir/24.cpp.o: CMakeFiles/24.dir/flags.make
CMakeFiles/24.dir/24.cpp.o: ../24.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/kruxx/git/Study/Labs/DM_Lab3/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/24.dir/24.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/24.dir/24.cpp.o -c /home/kruxx/git/Study/Labs/DM_Lab3/24.cpp

CMakeFiles/24.dir/24.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/24.dir/24.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/kruxx/git/Study/Labs/DM_Lab3/24.cpp > CMakeFiles/24.dir/24.cpp.i

CMakeFiles/24.dir/24.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/24.dir/24.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/kruxx/git/Study/Labs/DM_Lab3/24.cpp -o CMakeFiles/24.dir/24.cpp.s

# Object files for target 24
24_OBJECTS = \
"CMakeFiles/24.dir/24.cpp.o"

# External object files for target 24
24_EXTERNAL_OBJECTS =

24: CMakeFiles/24.dir/24.cpp.o
24: CMakeFiles/24.dir/build.make
24: CMakeFiles/24.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/kruxx/git/Study/Labs/DM_Lab3/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable 24"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/24.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/24.dir/build: 24

.PHONY : CMakeFiles/24.dir/build

CMakeFiles/24.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/24.dir/cmake_clean.cmake
.PHONY : CMakeFiles/24.dir/clean

CMakeFiles/24.dir/depend:
	cd /home/kruxx/git/Study/Labs/DM_Lab3/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/kruxx/git/Study/Labs/DM_Lab3 /home/kruxx/git/Study/Labs/DM_Lab3 /home/kruxx/git/Study/Labs/DM_Lab3/cmake-build-debug /home/kruxx/git/Study/Labs/DM_Lab3/cmake-build-debug /home/kruxx/git/Study/Labs/DM_Lab3/cmake-build-debug/CMakeFiles/24.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/24.dir/depend

