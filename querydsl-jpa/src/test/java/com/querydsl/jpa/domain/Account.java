/*
 * Copyright 2015, The Querydsl Team (http://www.querydsl.com/team)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.querydsl.jpa.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.querydsl.core.annotations.QueryInit;
import java.io.Serializable;
import javax.persistence.*;
import org.junit.Test;

/** The Class Account. */
@SuppressWarnings("serial")
@Entity
@Table(name = "account_")
public class Account implements Serializable {

  @Transient public int transientField;

  @Id long id;

  @ManyToOne
  @QueryInit("pid")
  Person owner;

  @Embedded EmbeddedType embeddedData;

  @Test
  public void test() {
    assertThrows(Exception.class, () -> QAccount.class.getField("serialVersionUID"));
    assertThrows(Exception.class, () -> QAccount.class.getField("transientField"));
  }
}
