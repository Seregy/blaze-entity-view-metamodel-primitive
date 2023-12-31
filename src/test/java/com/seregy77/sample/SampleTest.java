/*
 * Copyright 2014 - 2023 Blazebit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.seregy77.sample;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.view.EntityViewSetting;
import com.seregy77.model.Cat;
import com.seregy77.view.CatSimpleView;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class SampleTest extends AbstractSampleTest {

  @Override
  protected Class<?>[] getEntityViewClasses() {
    return new Class[]{
        CatSimpleView.class
    };
  }

  @Test
  public void sampleTest() {
    transactional(em -> {
      CriteriaBuilder<Cat> catCriteriaBuilder = cbf.create(em, Cat.class);
      catCriteriaBuilder.from(Cat.class, "cat");

      EntityViewSetting<CatSimpleView, CriteriaBuilder<CatSimpleView>> setting = EntityViewSetting.create(
          CatSimpleView.class);
      CriteriaBuilder<CatSimpleView> cb = evm.applySetting(setting, catCriteriaBuilder);
      List<CatSimpleView> list = cb.getResultList();

      System.out.println(list);
      Assert.assertEquals(6, list.size());
    });
  }
}
