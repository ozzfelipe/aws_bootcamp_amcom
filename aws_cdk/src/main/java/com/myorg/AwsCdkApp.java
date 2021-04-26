package com.myorg;

import software.amazon.awscdk.core.App;
import software.amazon.awscdk.core.Environment;
import software.amazon.awscdk.core.StackProps;

import java.util.Arrays;

public class AwsCdkApp {
    public static void main(final String[] args) {
        App app = new App();

        VpcStack vpcStack = new VpcStack(app, "Vpc");
        ClusterStack clusterStack = new ClusterStack(app, "Cluster",vpcStack.getVpc());
        clusterStack.addDependency(vpcStack);

        LoadBalancerService01Stack service01Stack = new LoadBalancerService01Stack(app,"Service01",clusterStack.getCluster());
        service01Stack.addDependency(clusterStack);

        app.synth();
    }
}
