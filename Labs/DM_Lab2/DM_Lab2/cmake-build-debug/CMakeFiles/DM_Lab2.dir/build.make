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
CMAKE_COMMAND = /snap/clion/92/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /snap/clion/92/bin/cmake/linux/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/kruxx/Documents/C/DM_Lab2

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/kruxx/Documents/C/DM_Lab2/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/DM_Lab2.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/DM_Lab2.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/DM_Lab2.dir/flags.make

CMakeFiles/DM_Lab2.dir/A.c.o: CMakeFiles/DM_Lab2.dir/flags.make
CMakeFiles/DM_Lab2.dir/A.c.o: ../A.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/kruxx/Documents/C/DM_Lab2/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/DM_Lab2.dir/A.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/DM_Lab2.dir/A.c.o   -c /home/kruxx/Documents/C/DM_Lab2/A.c

CMakeFiles/DM_Lab2.dir/A.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/DM_Lab2.dir/A.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/kruxx/Documents/C/DM_Lab2/A.c > CMakeFiles/DM_Lab2.dir/A.c.i

CMakeFiles/DM_Lab2.dir/A.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/DM_Lab2.dir/A.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/kruxx/Documents/C/DM_Lab2/A.c -o CMakeFiles/DM_Lab2.dir/A.c.s

# Object files for target DM_Lab2
DM_Lab2_OBJECTS = \
"CMakeFiles/DM_Lab2.dir/A.c.o"

# External object files for target DM_Lab2
DM_Lab2_EXTERNAL_OBJECTS =

DM_Lab2: CMakeFiles/DM_Lab2.dir/A.c.o
DM_Lab2: CMakeFiles/DM_Lab2.dir/build.make
DM_Lab2: CMakeFiles/DM_Lab2.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/kruxx/Documents/C/DM_Lab2/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable DM_Lab2"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/DM_Lab2.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/DM_Lab2.dir/build: DM_Lab2

.PHONY : CMakeFiles/DM_Lab2.dir/build

CMakeFiles/DM_Lab2.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/DM_Lab2.dir/cmake_clean.cmake
.PHONY : CMakeFiles/DM_Lab2.dir/clean

CMakeFiles/DM_Lab2.dir/depend:
	cd /home/kruxx/Documents/C/DM_Lab2/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/kruxx/Documents/C/DM_Lab2 /home/kruxx/Documents/C/DM_Lab2 /home/kruxx/Documents/C/DM_Lab2/cmake-build-debug /home/kruxx/Documents/C/DM_Lab2/cmake-build-debug /home/kruxx/Documents/C/DM_Lab2/cmake-build-debug/CMakeFiles/DM_Lab2.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/DM_Lab2.dir/depend
