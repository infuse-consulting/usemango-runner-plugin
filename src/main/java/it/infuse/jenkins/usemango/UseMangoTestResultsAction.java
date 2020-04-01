package it.infuse.jenkins.usemango;

import hudson.Util;
import hudson.model.Run;
import it.infuse.jenkins.usemango.model.TestIndexItem;
import jenkins.model.RunAction2;

import java.util.ArrayList;
import java.util.List;

public class UseMangoTestResultsAction implements RunAction2 {

    private transient Run run;
    private List<TestResult> tests;
    private String errorMessage;
    private String serverLink;

    public UseMangoTestResultsAction(String serverLink) {
        this.serverLink = serverLink;
    }

    @Override
    public String getIconFileName() { return "graph.png"; }

    @Override
    public String getDisplayName() {
        return "useMango Test Results";
    }

    @Override
    public String getUrlName() {
        return "useMangoResults";
    }

    @Override
    public void onAttached(Run<?, ?> run) { this.run = run; }

    @Override
    public void onLoad(Run<?, ?> run) {
        this.run = run;
    }

    public Run getRun() {
        return run;
    }

    public List<TestResult> getTests() { return this.tests; }

    public String getErrorMessage() { return this.errorMessage; }

    public void addTestResults(List<TestIndexItem> tests){
        this.tests = new ArrayList<>();
        for (TestIndexItem test: tests) {
            this.tests.add(new TestResult(test.getName(), test.isPassed(), getReportLink(test.getRunId())));
        }
    }

    public void setBuildException(String errorMessage){
        this.errorMessage = Util.escape(errorMessage);
    }

    private String getReportLink(String runId){
        return serverLink + "/report.html?runId=" + runId;
    }

    public static class TestResult {
        public final String name;
        public final String result;
        public final String reportLink;

        public TestResult(String name, Boolean passed, String reportLink){
            this.name = Util.escape(name);
            this.result = passed ? "Passed" : "Failed";
            this.reportLink = Util.escape(reportLink);
        }
    }
}
