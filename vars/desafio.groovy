import java.io.*
import java.util.*
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import pipeline.Families
import pipeline.Family
import pipeline.Member


def call(body) {

    //def branch = env.BRANCH_NAME 
    def yamlObj

    pipeline {
        agent any
        stages {
            
            stage('init') {
                steps {          
                    script {
                        //git branch: "main", credentialsId: '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', url: "https://github.com/ricarromani-sonaemc/desafio2.git"
                        
                        //sh "ls ${WORKSPACE}"
                        //yamlObj = readYaml file: "${WORKSPACE}/yaml-families/family.yaml"
                        yamlObj = readYaml file: "resources/member.yaml"
                        echo "${yamlObj}" 
                               
                    }   
                }
            }

            stage('convert yaml to object') {
                steps {
                    script {
                        Member member = new Member(new File("resources/member.yaml"));
                        Yaml yaml = new Yaml(new Constructor(Member.class));
                        Student data = yaml.load(member);
                        System.out.println(data);

                    }
                }
            }
        }
    }         
}


