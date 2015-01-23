package org.jenkinsci.plugins.latestbuildgraph.latestbuildgraph;

import hudson.Extension;
import hudson.model.*;
import jenkins.model.TransientActionFactory;
import org.jenkinsci.plugins.buildgraphview.BuildGraphActionFactory;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by christianlangmann on 23/01/15.
 */
@Extension
public class JumpToLatestBuildGraphFactory extends TransientActionFactory<Job> {

    private final static BuildGraphActionFactory buildGraphActionFactory = new BuildGraphActionFactory();

    @Override public Class<Job> type() {
        return Job.class;
    }

    @Override
    public Collection<? extends Action> createFor(Job abstractProject) {
        final List<Action> actions = new LinkedList<Action>();
        final Run lastBuild = abstractProject.getLastBuild();
        actions.addAll(buildGraphActionFactory.createFor(lastBuild));
        return actions;
    }
}
