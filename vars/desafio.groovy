import java.io.*
import java.util.*
@Grab('com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0')
import com.fasterxml.jackson.databind.ObjectMapper;
@Grab('com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.0')
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import dependencies.*

import pipeline.Families
import pipeline.Family
import pipeline.Member




def call(body) {

    //def branch = env.BRANCH_NAME 
    def yamlObj

    //def member2 = new Member()

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
                        
                        mapper = new ObjectMapper(new YAMLFactory());
                        mapper.findAndRegisterModules();
                        Member member = mapper.readValue(new File("resources/member.yaml"), Member.class);
                        /*
                        Member member = new Member();
                        member.setFirstName(yamlObj.firstName);
                        member.setLastName(yamlObj.lastName);
                        member.setJob(yamlObj.job);*/
                        

                        echo "${member.ToString()}"

                    }
                }
            }
            
        }
    }         
}
