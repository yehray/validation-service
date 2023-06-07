# validation-service
Spring Boot Web application for validating items. The validation service is part of an online store's
selling flow, meaning that sellers submit items through a Selling application which uses this
validation service to understand if the submitted item is valid and can be created.

The `Item` object has the following fields:
  * Site ID
  * Category ID
  * Title
  * Condition
  * Price
  * Quantity
  * Image URL (List | Multiple)
  * Item Specifics (Max 2)
  * Description

The validation service will reply with
either a successful response (i.e. item is valid) or a list of errors which represents the
issues found while validating the item.
