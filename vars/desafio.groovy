import java.io.*
import java.util.*
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import pipeline.Families
import pipeline.Family




def call(body) {

    //def branch = env.BRANCH_NAME 
    def yamlObj

    def member2 = new Member()

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

                        echo "${member}"

                    }
                }
            }
            
        }
    }         
}


@NonCPS
public class Member implements Serializable{
    private String firstName;
    private String lastName;
    private String job;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
}

