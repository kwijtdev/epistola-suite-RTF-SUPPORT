-- Add a separate JSONB payload for named rich-text content used during generation.
-- The regular data column remains the schema-validated render input; rich_content is
-- an optional overlay that is merged into the effective render data at runtime.
ALTER TABLE document_generation_requests
    ADD COLUMN rich_content JSONB;

COMMENT ON COLUMN document_generation_requests.rich_content IS 'Optional rich-text content payload keyed by slot/body name for runtime rendering overrides.';
