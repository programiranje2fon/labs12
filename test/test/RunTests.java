package test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import problem1.business_logic.ConverterTest;
import problem2.business_logic.BMICalculatorTest;

/**
 * This class executes all tests and prints out the report.
 * 
 */
public class RunTests {

	public static void main(String[] args) {
		runTestsForClass(ConverterTest.class);
		runTestsForClass(BMICalculatorTest.class);
	}

	/**
	 * Runs all tests declared in the class c.
	 * 
	 * @param c
	 *            class whose tests to run
	 */
	@SuppressWarnings("rawtypes")
	private static void runTestsForClass(Class c) {
		Result r = JUnitCore.runClasses(c);

		int totalCount = r.getRunCount();
		int failureCount = r.getFailureCount();
		int successfulCount = totalCount - failureCount;
		String className = c.getName().substring(0, c.getName().length() - 4); // remove last 4 characters "Test"

		if (r.wasSuccessful()) {
			System.out.println("------------------------------------------------");
			System.out.format("TEST CLASS: %s %n%n", className);
			System.out.format("Run: %-5d Passed: %-5d Failed: %-5d %n%n", totalCount, successfulCount,
					failureCount);
			System.out.println("\tAll tests passed!");
			System.out.println();
			System.out.flush();
		} else {
			System.err.println("------------------------------------------------");
			System.err.format("TEST CLASS: %s %n%n", className);
			System.err.format("Run: %-5d Passed: %-5d Failed: %-5d %n%n", totalCount, successfulCount,
					failureCount);

			// print the test summary only if there are no missing classes,
			// attributes or methods.
			if (thereAreNoLinkageErrors(r.getFailures())) {

				// create a map where TestTypes are keys. Values are maps with
				// the method name (from the tested class) is the key, and the
				// value is a two-dimensional array with the method stats (the
				// number of successful and the number of failed tests for the
				// method).
				Map<TestTypes, Map<String, int[]>> testTypeMethodMap = new LinkedHashMap<>();

				for (TestTypes testType : TestTypes.values()) {
					Map<String, int[]> methodStatsMap = new LinkedHashMap<>();

					for (Method method : c.getDeclaredMethods()) {
						String[] methodNameElements = method.getName().split("_");

						if (methodNameElements[0].equals(testType.namePrefix)) {
							String methodName = methodNameElements[1];

							int[] methodStats = null;

							// fetch the array if exists or create it
							if (methodStatsMap.containsKey(methodName)) {
								methodStats = methodStatsMap.get(methodName);
							} else {
								methodStats = new int[2];
								methodStatsMap.put(methodName, methodStats);
							}

							// check if test has failed
							if (isTestFailed(r.getFailures(), method.getName())) {
								methodStats[1]++; // increment the number of failed tests
							} else {
								methodStats[0]++; // otherwise, increment the number of successful tests
							}
							methodStatsMap.put(methodName, methodStats);
						}
					}

					// if for a given TestTypes instance there are no tests, do not add it
					if (!methodStatsMap.isEmpty())
						testTypeMethodMap.put(testType, methodStatsMap);
				}

				// print the method stats
				if (!testTypeMethodMap.isEmpty()) {
					for (TestTypes testType : testTypeMethodMap.keySet()) {
						System.err.println("Testing " + testType.pluralDative + ":");

						Map<String, int[]> methodsMap = testTypeMethodMap.get(testType);

						for (String methodName : methodsMap.keySet()) {
							int[] methodStats = methodsMap.get(methodName);

							System.err.printf("\t %-20s %s%n", methodName, methodStats[1] == 0 ? "OK" : "Failed: " + methodStats[1]);
						}
						System.err.println();
					}
				}
			}

			System.err.println("List of FAILED tests:\n");
			int i = 1;

			for (Failure failure : r.getFailures()) {
				Throwable ex = failure.getException();

				if (ex instanceof NoClassDefFoundError) {
					System.err.format(
							"%s. There is no class %s %n \t (check class name and package name) %n%n", i++,
							className);
				} else if (ex instanceof NoSuchFieldError) {
					System.err.format("%s. There is no attribute %s %n \t (check attribute type and name) %n%n",
							i++, ex.getMessage());
				} else if (ex instanceof NoSuchMethodError) {
					String methodName = failure.getDescription().getMethodName().split("_")[1];

					System.err.format(
							"%s. In class %s there is no method %s %n\t (check method name, return type, argument types and their order) %n%n",
							i++, className, methodName);
				} else {
					String[] methodNameElements = failure.getDescription().getMethodName().split("_");
					String methodName = methodNameElements[1];
					String testVariantName = null;

					if (methodNameElements.length > 2) {
						testVariantName = methodNameElements[2];
					}

					TestTypes testType = Arrays.stream(TestTypes.values())
							.filter(tt -> tt.namePrefix.equals(methodNameElements[0])).findAny().get();

					System.err.format("%s. Test %sfor the %s %s: %n \t%s %n%n", i++,
							testVariantName != null ? testVariantName + " " : "", testType.vocative, methodName,
							failure.getMessage());
				}
			}

			System.err.println();
			System.err.flush();
		}
	}

	/**
	 * Returns true if there are failures caused by missing classes, fields or
	 * methods. Otherwise, returns false.
	 * 
	 * @param failures
	 *            list of @{org.junit.runner.notification.Failure} instances.
	 * @return true or false
	 */
	private static boolean thereAreNoLinkageErrors(List<Failure> failures) {
		for (Failure failure : failures) {
			Throwable ex = failure.getException();
			if (ex instanceof NoClassDefFoundError || ex instanceof NoSuchFieldError || ex instanceof NoSuchMethodError)
				return false;
		}
		return true;
	}

	/**
	 * Returns true if there is a failed test for the given method name.
	 * 
	 * @param failureList
	 *            list of @{org.junit.runner.notification.Failure} instances.
	 * @param methodName
	 *            name of the method to search the test for
	 * @return true or false
	 */
	private static boolean isTestFailed(List<Failure> failureList, String methodName) {
		return failureList.stream().anyMatch(f -> f.getDescription().getMethodName().equals(methodName));
	}

	/**
	 * Enum for different types of tests. There is an instance for each element
	 * that can be tested.
	 * 
	 */
	private enum TestTypes {
		CLASS("class", "classes", "class"), 
		ATTRIBUTE("attribute", "attributes", "attribute"), 
		CONSTANT("constant", "constants", "constant"), 
		ENUM("enum", "enums", "enum"), 
		CONSTRUCTOR("constructor", "constructors", "constructor"), 
		METHOD("method", "methods", "method");

		private String namePrefix;
		private String pluralDative;
		private String vocative;

		private TestTypes(String name, String headingText, String vocative) {
			this.namePrefix = name;
			this.pluralDative = headingText;
			this.vocative = vocative;
		}
	}
}
