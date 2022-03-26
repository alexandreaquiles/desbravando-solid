module cotuba.web {
  requires cotuba.core;

  requires java.persistence;
  requires java.validation;

  requires spring.context;
  requires spring.web;

  requires spring.data.jpa;

  requires spring.boot;
  requires spring.boot.autoconfigure;

  requires org.apache.tomcat.embed.core;
}