# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.15

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

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2019.2.4\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2019.2.4\bin\cmake\win\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\Anon\CLionProjects\DM_Lab1_E

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\Anon\CLionProjects\DM_Lab1_E\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/DM_Lab1_E.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/DM_Lab1_E.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/DM_Lab1_E.dir/flags.make

CMakeFiles/DM_Lab1_E.dir/main.cpp.obj: CMakeFiles/DM_Lab1_E.dir/flags.make
CMakeFiles/DM_Lab1_E.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\Anon\CLionProjects\DM_Lab1_E\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/DM_Lab1_E.dir/main.cpp.obj"
	C:\PROGRA~2\mingw-w64\i686-8.1.0-posix-dwarf-rt_v6-rev0\mingw32\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\DM_Lab1_E.dir\main.cpp.obj -c C:\Users\Anon\CLionProjects\DM_Lab1_E\main.cpp

CMakeFiles/DM_Lab1_E.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/DM_Lab1_E.dir/main.cpp.i"
	C:\PROGRA~2\mingw-w64\i686-8.1.0-posix-dwarf-rt_v6-rev0\mingw32\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\Users\Anon\CLionProjects\DM_Lab1_E\main.cpp > CMakeFiles\DM_Lab1_E.dir\main.cpp.i

CMakeFiles/DM_Lab1_E.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/DM_Lab1_E.dir/main.cpp.s"
	C:\PROGRA~2\mingw-w64\i686-8.1.0-posix-dwarf-rt_v6-rev0\mingw32\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\Users\Anon\CLionProjects\DM_Lab1_E\main.cpp -o CMakeFiles\DM_Lab1_E.dir\main.cpp.s

# Object files for target DM_Lab1_E
DM_Lab1_E_OBJECTS = \
"CMakeFiles/DM_Lab1_E.dir/main.cpp.obj"

# External object files for target DM_Lab1_E
DM_Lab1_E_EXTERNAL_OBJECTS =

DM_Lab1_E.exe: CMakeFiles/DM_Lab1_E.dir/main.cpp.obj
DM_Lab1_E.exe: CMakeFiles/DM_Lab1_E.dir/build.make
DM_Lab1_E.exe: CMakeFiles/DM_Lab1_E.dir/linklibs.rsp
DM_Lab1_E.exe: CMakeFiles/DM_Lab1_E.dir/objects1.rsp
DM_Lab1_E.exe: CMakeFiles/DM_Lab1_E.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Users\Anon\CLionProjects\DM_Lab1_E\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable DM_Lab1_E.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\DM_Lab1_E.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/DM_Lab1_E.dir/build: DM_Lab1_E.exe

.PHONY : CMakeFiles/DM_Lab1_E.dir/build

CMakeFiles/DM_Lab1_E.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\DM_Lab1_E.dir\cmake_clean.cmake
.PHONY : CMakeFiles/DM_Lab1_E.dir/clean

CMakeFiles/DM_Lab1_E.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\Anon\CLionProjects\DM_Lab1_E C:\Users\Anon\CLionProjects\DM_Lab1_E C:\Users\Anon\CLionProjects\DM_Lab1_E\cmake-build-debug C:\Users\Anon\CLionProjects\DM_Lab1_E\cmake-build-debug C:\Users\Anon\CLionProjects\DM_Lab1_E\cmake-build-debug\CMakeFiles\DM_Lab1_E.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/DM_Lab1_E.dir/depend
