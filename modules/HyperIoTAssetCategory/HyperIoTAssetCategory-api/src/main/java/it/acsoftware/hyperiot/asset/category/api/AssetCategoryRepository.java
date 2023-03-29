/*
 * Copyright 2019-2023 HyperIoT
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package it.acsoftware.hyperiot.asset.category.api;

import it.acsoftware.hyperiot.asset.category.model.AssetCategory;
import it.acsoftware.hyperiot.asset.category.model.AssetCategoryResource;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;

/**
 * 
 * @author Aristide Cittadino Interface component for AssetCategory Repository.
 *         It is used for CRUD operations, and to interact with the persistence
 *         layer.
 *
 */
public interface AssetCategoryRepository extends HyperIoTBaseRepository<AssetCategory> {
	public AssetCategoryResource findAssetCategoryResource(String resourceName, long resourceId,
			long categoryId);
}
